package com.api.manage.config;

import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.BorrowDao;
import com.api.manage.dao.chargeManagement.SysDailyPaymentDao;
import com.api.manage.dao.remind.RemindDao;
import com.api.model.butlerService.SysArticleBorrow;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.systemDataBigScreen.DailyActivity;
import com.api.systemDataBigScreen.dao.SystemDataDao;
import com.api.util.JiguangUtil;
import com.api.vo.chargeManagement.VoFindAllDailyPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 系统自动 提醒/推送
 *
 * Cron表达式参数分别表示（从左到右，）：
 * :@Scheduled(cron = "0 0/10 * * * ?") 注意：前面为0 后面为*
 * 按顺序依次为
 * 秒（0~59）
 * 分钟（0~59）
 * 小时（0~23）
 * 天（月）（0~31，但是你需要考虑你月的天数）
 * 月（0~11）
 * 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
 * 7.年份（1970－2099）
 *
 * 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。
 * 由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
 *
 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 * 0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
 * 0 0 12 ? * WED 表示每个星期三中午12点
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 */
@Configuration
@EnableScheduling
@Slf4j
public class SysAutoRemind {
    @Resource
    BorrowDao borrowDao;
    @Resource
    RemindDao remindDao;
    @Resource
    SysDailyPaymentDao sysDailyPaymentDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    SystemDataDao systemDataDao;

    /**
     * 后台系统借还提醒，每隔一天进行校对数据库，如果出借时长超过7天则系统自动发出提醒
     */
    //从下日开始，每1天执行一次
    @Scheduled(cron = "0 0 0 1/1 * ?")
    //从0秒开始，每10秒执行一次，测试专用
//    @Scheduled(cron = "0/10 * * * * ?")
    private void sysBorrowRemind() {
        System.out.println("【定时任务】 每1天执行一次借还提醒！");
        try {
            List<SysArticleBorrow> sysArticleBorrows = borrowDao.findAll();
            if (sysArticleBorrows != null && sysArticleBorrows.size()>0){
                for (SysArticleBorrow sysArticleBorrow : sysArticleBorrows) {
                    //计算出借出时长[单位为天]
                    long day = (new Date().getTime() - sysArticleBorrow.getBeginDate().getTime())/(24*60*60*1000);
                    if (day > 7 && sysArticleBorrow.getStatus() == 1){
                        //如果超过7天则系统发出提醒
                        SysMessage sysMessage = new SysMessage();
                        //填入标题
                        sysMessage.setTitle("借还提醒");
                        //填入消息内容
                        sysMessage.setContent("亲，扳手您还在出借当中噢，如果您未使用了，记得归还物业！");
                        //填入发送人id（系统发送为-1）
                        sysMessage.setSender(-1);
                        //填入创建时间
                        sysMessage.setGenerateDate(new Date());
                        //填入发送时间
                        sysMessage.setSendDate(new Date());
                        //填入发送类型（1.系统广播，2.管理员消息）
                        sysMessage.setType(1);
                        //添加提醒 消息列表 并返回主键id
                        int insert = remindDao.insertMessage(sysMessage);
                        if (insert <= 0){
                            throw new RuntimeException("添加消息列表失败");
                        }

                        SysSending sysSending = new SysSending();
                        //填入消息id
                        sysSending.setMessageId(sysMessage.getId());
                        //填入接收人id
                        sysSending.setReceiverAccount(sysArticleBorrow.getCreateId());
                        //填入发送状态（0.未发或不成功1.发送成功，3.已读）[初始为0，用户打开app为1，查看为3]
                        sysSending.setSendStatus(1);
                        //填入发送日期
                        sysSending.setSendDate(new Date());
                        //添加消息接收列表
                        int i = remindDao.insertSending(sysSending);
                        if (i <= 0){
                            throw new RuntimeException("添加消息接收列表失败");
                        }
                        JiguangUtil.push(String.valueOf(sysArticleBorrow.getCreateId()),"借还提醒");
                    }
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            //打印日志地方
            System.out.println(message);
        }
        //打印日志地方
        System.out.println("更新成功");
    }


    /**
     * 后台系统日常缴费提醒，如果到月初，则系统则给未缴纳费用的用户自动发出提醒
     */
    //每月1号，系统则给未缴纳费用的用户自动发出提醒
    @Scheduled(cron = "0 0 0 1 * ?")
    private void sysDailyPaymentRemind() {
        System.out.println("【每日定时检查任务】 每到月初（1号）就执行一次日常缴费提醒！");
        try {
            //查询所有的日常缴费信息
            List<VoFindAllDailyPayment> voFindAllDailyPaymentList = sysDailyPaymentDao.findAll();
            //判断是否有缴费信息
            if (voFindAllDailyPaymentList != null && voFindAllDailyPaymentList.size()>0){
                for (VoFindAllDailyPayment voFindAllDailyPayment : voFindAllDailyPaymentList) {
                    //如果待缴金额大于0，则系统自动发送日常缴费提醒，否则不发送
                    if (voFindAllDailyPayment.getPaymentPrice().compareTo(BigDecimal.ZERO) == 1 ){
                        //如果待缴金额大于0，则系统自动发送日常缴费提醒
                        SysMessage sysMessage = new SysMessage();
                        //填入标题
                        sysMessage.setTitle("日常缴费提醒");
                        //填入消息内容
                        sysMessage.setContent("亲，您的物业费已经到期了，为了不影响您的居住环境，请登入app或者来物业大厅缴费，谢谢");
                        //填入发送人id（系统发送为-1）
                        sysMessage.setSender(-1);
                        //填入创建时间
                        sysMessage.setGenerateDate(new Date());
                        //填入发送时间
                        sysMessage.setSendDate(new Date());
                        //填入发送类型（1.系统广播，2.管理员消息）
                        sysMessage.setType(1);
                        //添加提醒 消息列表 并返回主键id
                        int insert = remindDao.insertMessage(sysMessage);
                        if (insert <= 0){
                            throw new RuntimeException("添加消息列表失败");
                        }

                        SysSending sysSending = new SysSending();
                        //填入消息id
                        sysSending.setMessageId(sysMessage.getId());
                        //填入接收人id
                        //根据房产id查询业主id
                        List<Integer> residentIds = cpmBuildingUnitEstateDao.findResidentIdByEstateId(voFindAllDailyPayment.getBuildingUnitEstateId());
                        //传入业主id,如果有2个，则取数据库中排序的第一个
                        sysSending.setReceiverAccount(residentIds.get(0));
                        //填入发送状态（0.未发或不成功1.发送成功，3.已读）[初始为0，用户打开app为1，查看为3]
                        sysSending.setSendStatus(1);
                        //填入发送日期
                        sysSending.setSendDate(new Date());
                        //添加消息接收列表
                        int i = remindDao.insertSending(sysSending);
                        if (i <= 0){
                            throw new RuntimeException("添加消息接收列表失败");
                        }
                        JiguangUtil.push(String.valueOf(residentIds.get(0)),"日常缴费提醒");
                    }else {
                        //如果待缴金额不大于0，则跳过，不发送日常缴费提醒
                    }
                }
            }
        } catch (RuntimeException e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            //打印日志地方
            System.out.println(message);
        }
        //打印日志地方
        System.out.println("已到月初，发送日常缴费提醒");
    }

    /**
     * 每日23时59分 统计日活跃量 进数据库
     */
    @Scheduled(cron = "0 59 23 1/1 * ? ")
    private void dailyActivity(){
        Date date = new Date();
        //查询本日 日活跃量
        int count = systemDataDao.findTodayDailyActivity(date);
        DailyActivity dailyActivity = new DailyActivity();
        dailyActivity.setDailyActivityNum(count);
        dailyActivity.setCreateDate(date);
        //将日活跃量 添加进数据库
        int insert = systemDataDao.insertDailyActivity(dailyActivity);
        if (insert >0){
            log.info("统计日活跃量成功");
        }else {
            log.info("统计日活跃量失败");
        }
    }

    @Scheduled(cron = "0 43 * * * ?")
    public void test(){
        System.out.println("测试定时任务");

    }
}
