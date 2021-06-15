package com.api.manage.config;

import com.api.alipay.service.AlipayService;
import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.butlerApp.dao.butler.ButlerAttendanceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.BorrowDao;
import com.api.manage.dao.butlerService.SysFacilitiesPlanDao;
import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.manage.dao.chargeManagement.SysDailyPaymentDao;
import com.api.manage.dao.operationManagement.SysNewsManagementDao;
import com.api.manage.dao.remind.RemindDao;
import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.service.operationManagement.SysNewsManagementService;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppGoodsIdAndAppointmentNum;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerExecuteIdAndActualEndDate;
import com.api.model.butlerService.*;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.util.IdWorker;
import com.api.util.JiguangUtil;
import com.api.vo.chargeManagement.VoFindAllDailyPayment;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    ButlerInspectionDao butlerInspectionDao;
    @Resource
    SysInspectionPlanDao sysInspectionPlanDao;
    @Resource
    SysFacilitiesPlanDao sysFacilitiesPlanDao;
    @Resource
    ButlerAttendanceDao butlerAttendanceDao;
    @Resource
    SysNewsManagementService sysNewsManagementService;
    @Resource
    ShoppingDao shoppingDao;
    @Resource
    AlipayService alipayService;


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
            log.info(message);
        }
        //打印日志地方
        log.info("更新成功");
    }


    /**
     * 后台系统日常缴费提醒，如果到月初，则系统则给未缴纳费用的用户自动发出提醒
     */
    //每月1号0点1秒，系统则给未缴纳费用的用户自动发出提醒
    @Scheduled(cron = "1 0 0 1 * ?")
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
            log.info(message);
        }
        //打印日志地方
        log.info("已到月初，发送日常缴费提醒");
    }

    /**
     * 0 0 0 1/1 * ?
     * 0/5 * * * * ?
     * (每天0点1分)自动更新巡检信息（当天巡检还处于待巡检状态：本次巡检过期，结束时间填写为现在，并添加下一次巡检执行情况）
     */
    @Scheduled(cron = "0 1 0 1/1 * ? ")
    public void autoInspection(){
        Date date = new Date();
        //根据当前时间，查询计划当次巡检开始时间小于当天的 并实际当次巡检结束时间为null的巡检执行情况数据
        List<SysInspectionExecute> sysInspectionExecuteList = butlerInspectionDao.findOldExecuteByToday(date);
        if (sysInspectionExecuteList != null && sysInspectionExecuteList.size()>0){
            for (SysInspectionExecute sysInspectionExecute : sysInspectionExecuteList) {
                //当 当前时间的日期（年月日）大于添加后的当次巡检开始时间的日期（年月日），继续添加巡检计划，并将添加后的当次巡检计划变为未巡检状态
                Date time = sysInspectionExecute.getBeginDate();
                while (dateCompare(new Date(),time)){
                    //查询最新的一次计划当次巡检开始时间
                    sysInspectionExecute = sysInspectionPlanDao.findNewPlan(sysInspectionExecute.getInspectionPlanId());

                    //先修改
                    //修改当次巡检情况实际结束时间
                    ButlerExecuteIdAndActualEndDate executeIdAndActualEndDate = new ButlerExecuteIdAndActualEndDate();
                    executeIdAndActualEndDate.setExecuteId(sysInspectionExecute.getId());
                    executeIdAndActualEndDate.setActualEndDate(new Date());
                    int update3 = butlerInspectionDao.updateExecute(executeIdAndActualEndDate);
                    if (update3 <= 0){
                        log.info("修改当次巡检情况实际结束时间失败,巡检执行情况主键id:"+sysInspectionExecute.getId());
                        break;
                    }
                    log.info("修改当次巡检情况实际结束时间成功,巡检执行情况主键id:"+sysInspectionExecute.getId());

                    //后添加新执行计划
                    //根据巡检计划主键id 查询 巡检计划情况
                    SysInspectionPlan sysInspectionPlan = butlerInspectionDao.findPlanById(sysInspectionExecute.getInspectionPlanId());
                    if (sysInspectionPlan != null && sysInspectionPlan.getStatus() ==1){ //启用
                        //添加下一条巡检计划
                        SysInspectionExecute sysInspectionExecute3 = new SysInspectionExecute();
                        sysInspectionExecute3.setInspectionPlanId(sysInspectionExecute.getInspectionPlanId()); //填入巡检计划主键id
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(time);
                        switch (sysInspectionPlan.getCheckRateType()){
                            case 1:
                                calendar.add(Calendar.DAY_OF_MONTH,1);
                                break;
                            case 2:
                                calendar.add(Calendar.DAY_OF_MONTH,7);
                                break;
                            case 3:
                                calendar.add(Calendar.MONTH,1);
                                break;
                            default:
                                log.info("数据异常,巡检执行情况主键id:"+sysInspectionExecute.getId());
                                break;
                        }
                        time = calendar.getTime();
                        sysInspectionExecute3.setBeginDate(time); //填入计划当次巡检开始时间
                        //根据巡检路线主键id查询 持续时间
                        Integer spaceTime = butlerInspectionDao.findSpaceTimeById(sysInspectionPlan.getInspectionRouteId());
                        if (spaceTime == null){
                            log.info("数据异常2,巡检执行情况主键id:"+sysInspectionExecute.getId());
                            break;
                        }
                        calendar.setTime(time);
                        calendar.add(Calendar.MINUTE,spaceTime);
                        Date time2 = calendar.getTime();
                        sysInspectionExecute3.setEndDate(time2); //填入计划当次巡检结束时间
                        //根据巡检计划主键id查询巡检执行数量
                        int count2 = butlerInspectionDao.countExecuteNumByPlanId(sysInspectionExecute.getInspectionPlanId());
                        sysInspectionExecute3.setSort(count2+1); //填入排序默认为1
                        int insert2 = sysInspectionPlanDao.insertExecute(sysInspectionExecute3);
                        if (insert2 <=0){
                            log.info("添加执行巡检信息失败,巡检执行情况主键id:"+sysInspectionExecute.getId());
                            break;
                        }
                        log.info("添加执行巡检信息成功,巡检执行情况主键id:"+sysInspectionExecute.getId());
                    }else {
                        log.info("当前巡检计划已被关闭或删除,检查执行情况主键id:"+sysInspectionExecute.getId());
                        break;
                    }
                }
            }
        }else {
            log.info("本次执行没有处理对象");
        }
    }

    /**
     * 0 0 0 1/1 * ?
     * 0/5 * * * * ?
     * （每天0点10秒）自动更新设施/设备检查信息（当天检查还处于1.待完成状态：修改状态为3.未完成，并添加下一次检查执行情况）
     */
    @Scheduled(cron = "10 0 0 1/1 * ? ")
    public void autoFacilities(){
        Date date = new Date();
        //根据当前时间，查询计划当次检查开始时间小于当天的 并状态为待完成的检查执行记录
        List<FacilitiesExecute> executes = sysFacilitiesPlanDao.findOldExecuteByToday(date);
        if (executes != null && executes.size()>0){
            for (FacilitiesExecute execute : executes) {
                //当 当前时间的日期（年月日）大于添加后的当次检查开始时间的日期（年月日），继续添加检查计划，并将添加后的当次检查计划变为未完成状态
                Date time = execute.getBeginDate();
                while (dateCompare(new Date(),time)){
                    //查询最新的一次计划当次检查开始时间
                    execute = sysFacilitiesPlanDao.findNewPlan(execute.getFacilitiesPlanId());
                    //修改当次检查情况状态为，3.未完成
                    int update3 = sysFacilitiesPlanDao.updateExecuteStatus(execute.getId());
                    if (update3 <= 0){
                        log.info("修改当次检查情况状态失败,检查执行情况主键id:"+execute.getId());
                        break;
                    }
                    log.info("修改当次检查情况状态成功,检查执行情况主键id:"+execute.getId());

                    //根据检查计划主键id 查询 检查计划情况
                    FacilitiesPlan plan = sysFacilitiesPlanDao.findById(execute.getFacilitiesPlanId());
                    if (plan != null && plan.getStatus() ==1){//未被删除，并启用
                        //添加下一条检查计划
                        FacilitiesExecute execute3 = new FacilitiesExecute();
                        execute3.setFacilitiesPlanId(execute.getFacilitiesPlanId());//填入检查计划主键id
                        execute3.setStatus(1);//添加默认，1.待完成

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(time);
                        switch (plan.getCheckRateType()){
                            case 1:
                                calendar.add(Calendar.DAY_OF_MONTH,1);
                                break;
                            case 2:
                                calendar.add(Calendar.DAY_OF_MONTH,7);
                                break;
                            case 3:
                                calendar.add(Calendar.MONTH,1);
                                break;
                            default:
                                log.info("数据异常,巡检执行情况主键id:"+execute.getId());
                                break;
                        }
                        time = calendar.getTime();
                        execute3.setBeginDate(time); //填入计划当次检查开始时间

                        calendar.setTime(time);
                        calendar.add(Calendar.MINUTE,plan.getSpaceTime());
                        Date time2 = calendar.getTime();
                        execute3.setEndDate(time2); //填入计划当次检查结束时间

                        //根据检查计划主键id查询检查执行数量
                        int count2 = sysFacilitiesPlanDao.countExecuteNumByPlanId(execute.getFacilitiesPlanId());
                        execute3.setSort(count2+1); //填入排序默认为1
                        int insert2 = sysFacilitiesPlanDao.insertExecute(execute3);
                        if (insert2 <=0){
                            log.info("添加执行检查信息失败,检查执行情况主键id:"+execute.getId());
                            break;
                        }
                        log.info("添加执行检查信息成功,检查执行情况主键id:"+execute.getId());
                    }else {
                        log.info("当前巡检计划已被关闭或删除,检查执行情况主键id:"+execute.getId());
                        break;
                    }
                }
            }
        }else {
            log.info("本次执行没有处理对象");
        }
    }


    /**
     * 0 0/1 * * * ?
     * （每天0点1秒）每晚定时任务，自动为每一个物业账号生成当日考勤任务
     */
    @Scheduled(cron = "1 0 0 1/1 * ? ")
    public void autoAttendanceRecord(){


        int status = 2;//状态：1.放假日（节假），2.工作日，3.休息日（双休）
        //查询今日是周几，周日是1，依次类推
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int i = cal.get(Calendar.DAY_OF_WEEK);
        if (i == 7 || i ==1){//7.周六，1.周日
            log.info("今日是双休日");
            status = 3;
        }else {
            log.info("今日是工作日");
            status = 2;
        }

        //查询所有的需要执行考勤任务的物业人员信息(用户未删除，状态正常)
        List<SysUser> sysUserList = butlerAttendanceDao.findAllSysUer();

        if (sysUserList != null && sysUserList.size()>0){
            AttendanceRecord attendanceRecord = new AttendanceRecord();
            attendanceRecord.setCreateDate(new Date());
            for (SysUser sysUser : sysUserList) {
                attendanceRecord.setClockId(sysUser.getId());
                attendanceRecord.setStatus(status);
                //添加考勤任务记录
                int insert = butlerAttendanceDao.autoAttendanceRecord(attendanceRecord);
                if (insert <=0){
                    log.info("添加用户考勤任务失败,用户主键id:"+sysUser.getId());
                }
            }
        }else {
            log.info("本次执行没有处理对象");
        }
    }


    /**
     *
     * （每天0点1秒）每晚定时任务，自动爬取更新医药网健康家园信息
     */
    @Scheduled(cron = "1 0 0 1/1 * ? ")
    public void autoCrawlingMedical(){
        //更新医药网爬取信息并返回更新条数
        int medicalNum = sysNewsManagementService.updateMedical();
        log.info("更新条数为:"+medicalNum);
    }

    /**
     *
     * （每天0点1秒）每晚定时任务，自动爬取更新学信网信息
     */
    @Scheduled(cron = "1 0 0 1/1 * ? ")
    public void autoCrawlingEducation(){
        //更新学信网爬取信息并返回更新条数
        int educationNum = sysNewsManagementService.updateEducation();
        log.info("更新条数为:"+educationNum);
    }

    /**
     * 0 0/30 * * * ?
     * （每30分钟执行一次）轮询定时任务，进行超时，支付失败的商品订单的库存回库处理
     */
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void autoShoppingBackLibrary(){
        //查询未缴纳订单信息
        List<AppGoodsAppointment> appGoodsAppointments2 =  shoppingDao.findUnPaymentOrder();
        if (appGoodsAppointments2 != null && appGoodsAppointments2.size()>0){
            for (AppGoodsAppointment appGoodsAppointment : appGoodsAppointments2) {
                //先进行查询未缴纳订单信息，查询是否超时
                Map<String, Object> map = alipayService.shoppingCheckAlipay(appGoodsAppointment.getCode());
                int status = (int)map.get("status");
                if (status != -1){
                    log.info("订单查询成功,订单号为："+appGoodsAppointment.getCode()+",message:"+map.get("message"));
                }else {
                    log.info("订单查询失败,订单号为："+appGoodsAppointment.getCode()+",message:"+map.get("message"));
                }
            }
        }else {
            log.info("暂无待付款订单");
        }


        //查询已超时的需要进行回库的商品预约订单
        List<AppGoodsAppointment> appGoodsAppointments = shoppingDao.findBackGoodsOrder();
        if (appGoodsAppointments != null && appGoodsAppointments.size()>0){
            for (AppGoodsAppointment appGoodsAppointment : appGoodsAppointments) {
                AppGoodsIdAndAppointmentNum appGoodsIdAndAppointmentNum = new AppGoodsIdAndAppointmentNum();
                appGoodsIdAndAppointmentNum.setGoodsId(appGoodsAppointment.getGoodsId());
                appGoodsIdAndAppointmentNum.setAppointmentNum(appGoodsAppointment.getNum());

                //增加对应商品的库存，减少预约量
                int update = shoppingDao.decGoodsAppointmentNum(appGoodsIdAndAppointmentNum);
                if (update <= 0){
                    log.info("库存回库失败,商品预约订单主键id："+appGoodsAppointment.getId());
                }

                //更新商品预约订单的back_library（是否库存回库）为1.已回库
                int update2 = shoppingDao.updateBackLibraryByOrderId(appGoodsAppointment.getId());
                if (update2 <= 0){
                    log.info("商品预约订单的back_library更新失败,商品预约订单主键id："+appGoodsAppointment.getId());
                }
                log.info("回库成功,回库订单号为:"+appGoodsAppointment.getCode());
            }
        }else {
            log.info("暂无回库订单");
        }
    }

    /**
     * 比较第一个值date和第二个值time
     * @param date 第一个值
     * @param time 第二个值
     * @return date>time true date
     */
    private boolean dateCompare(Date date, Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateFirst = dateFormat.format(date);
        String dateLast = dateFormat.format(time);
        int dateFirstIntVal = Integer.parseInt(dateFirst);
        int dateLastIntVal = Integer.parseInt(dateLast);
        if (dateFirstIntVal > dateLastIntVal) {
            //第一个值大于第二个值true
            return true;
        } else if (dateFirstIntVal < dateLastIntVal) {
            //第一个值小于第二个值false
            return false;
        }
        //第一个值等于第二个值false
        return false;
    }


    @Scheduled(cron = "0 43 * * * ? ")
    public void test(){
//        String curName = Thread.currentThread().getName() ;
//        System.out.println("当前时间:"+ new Date()+"  任务execute1对应的线程名: "+curName);
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        log.info("测试定时任务1");
    }

    @Scheduled(cron = "0 43 * * * ? ")
    public void test2(){
//        String curName = Thread.currentThread().getName() ;
//        System.out.println("当前时间:"+new Date()+"  任务execute2对应的线程名: "+curName);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("测试定时任务2");
    }
}
