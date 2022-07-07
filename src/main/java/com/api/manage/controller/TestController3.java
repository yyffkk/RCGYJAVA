package com.api.manage.controller;

import com.api.butlerApp.dao.butler.ButlerAttendanceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.BorrowDao;
import com.api.manage.dao.butlerService.SysFacilitiesPlanDao;
import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.manage.dao.chargeManagement.SysDailyPaymentDao;
import com.api.manage.dao.remind.RemindDao;
import com.api.model.butlerApp.ButlerExecuteIdAndActualEndDate;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.butlerService.SysInspectionExecute;
import com.api.model.butlerService.SysInspectionPlan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("manage/test3")
public class TestController3 {
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

    @GetMapping("/autoFacilities")
    public boolean autoFacilities(){
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

                    //先修改
                    //修改当次检查情况状态为，3.未完成
                    int update3 = sysFacilitiesPlanDao.updateExecuteStatus(execute.getId());
                    if (update3 <= 0){
                        log.info("修改当次检查情况状态失败,检查执行情况主键id:"+execute.getId());
                        break;
                    }
                    log.info("修改当次检查情况状态成功,检查执行情况主键id:"+execute.getId());

                    //后添加新执行计划
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
        return true;
    }


    @GetMapping("/autoInspection")
    public Boolean autoInspection(HttpServletRequest request) throws IOException {
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
        return true;
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
}
