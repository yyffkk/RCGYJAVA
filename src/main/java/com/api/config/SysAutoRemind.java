package com.api.config;

import com.api.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.dao.butlerService.BorrowDao;
import com.api.dao.chargeManagement.SysDailyPaymentDao;
import com.api.dao.remind.RemindDao;
import com.api.model.butlerService.SysArticleBorrow;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.vo.chargeManagement.VoFindAllDailyPayment;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 系统自动 提醒/推送
 *
 * Cron表达式参数分别表示（从左到右，）：
 * :@Scheduled(cron = "0 0/10 * * * ?") 注意：前面为0 后面为*
 * 秒（0~59） 如0/5表示每5秒
 * 分（0~59）
 * 时（0~23）
 * 日（0~31) 月的某一天
 * 月（0~11）
 * 周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
 */
@Configuration
@EnableScheduling
public class SysAutoRemind {
    @Resource
    BorrowDao borrowDao;
    @Resource
    RemindDao remindDao;
    @Resource
    SysDailyPaymentDao sysDailyPaymentDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;

    /**
     * 后台系统借还提醒，每隔一天进行校对数据库，如果出借时长超过7天则系统自动发出提醒
     */
    //1天执行一次
    @Scheduled(cron = "0 0 0 0/1 * ?")
    //10秒执行一次，测试专用
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
                        sysSending.setSendStatus(0);
                        //填入发送日期
                        sysSending.setSendDate(new Date());
                        //添加消息接收列表
                        int i = remindDao.insertSending(sysSending);
                        if (i <= 0){
                            throw new RuntimeException("添加消息接收列表失败");
                        }
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
     * 后台系统日常缴费提醒，每隔一天进行校对数据库，如果到月初，则系统则给未缴纳费用的用户自动发出提醒
     */
    //1天执行一次
    @Scheduled(cron = "0 0 0 0/1 * ?")
    //10秒执行一次，测试专用
//    @Scheduled(cron = "0/10 * * * * ?")
    private void sysDailyPaymentRemind() {
        System.out.println("【每日定时检查任务】 每到月初就执行一次日常缴费提醒！");

        //获取当前时间
        Calendar now = Calendar.getInstance();
        //获取当前是几号
        int day = now.get(Calendar.DAY_OF_MONTH);
        //获取当前是几时
        int hour = now.get(Calendar.HOUR_OF_DAY);
        //获取当前是几分
        int minute = now.get(Calendar.MINUTE);
        //获取当前是几秒
        int second = now.get(Calendar.SECOND);
        System.out.println("月任务 判断中");
        System.out.println("当前时间："+day+"号"+hour+"时"+minute+"分"+second+"秒");
        //如果到月初 --1号--
        if (day == 1){
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
                            sysSending.setSendStatus(0);
                            //填入发送日期
                            sysSending.setSendDate(new Date());
                            //添加消息接收列表
                            int i = remindDao.insertSending(sysSending);
                            if (i <= 0){
                                throw new RuntimeException("添加消息接收列表失败");
                            }
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
        }else {
            System.out.println("未到月初，暂不发送");
        }
    }
}
