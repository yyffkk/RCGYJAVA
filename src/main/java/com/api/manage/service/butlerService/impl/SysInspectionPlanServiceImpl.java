package com.api.manage.service.butlerService.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.manage.dao.butlerService.SysInspectionRouteDao;
import com.api.manage.service.butlerService.SysInspectionPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.*;
import com.api.systemDataBigScreen.dao.SystemDataDao;
import com.api.util.IdWorker;
import com.api.vo.butlerService.VoFBIInspectionPlan;
import com.api.vo.butlerService.VoInspectionExecute;
import com.api.vo.butlerService.VoInspectionPlan;
import com.api.vo.systemDataBigScreen.SDInspectionExecuteMapVo;
import com.api.vo.systemDataBigScreen.SDInspectionExecutePointVo;
import com.api.vo.systemDataBigScreen.SDInspectionExecuteVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysInspectionPlanServiceImpl implements SysInspectionPlanService {
    @Resource
    SysInspectionPlanDao sysInspectionPlanDao;
    @Resource
    SysInspectionRouteDao sysInspectionRouteDao;
    @Resource
    ButlerInspectionDao butlerInspectionDao;
    @Resource
    SystemDataDao systemDataDao;
    private static Map<String,Object> map = null;


    @Override
    public List<VoInspectionPlan> list(SearchInspectionPlan searchInspectionPlan) {
        return sysInspectionPlanDao.list(searchInspectionPlan);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysInspectionPlan sysInspectionPlan) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            sysInspectionPlan.setCreateId(sysUser.getId()); //填入创建人id
            sysInspectionPlan.setCreateDate(new Date()); //填入创建时间
            sysInspectionPlan.setIsDelete(1); //默认为1.删除
            sysInspectionPlan.setCode(String.valueOf(new IdWorker(1,1,1).nextId())); //填入巡检计划编号
            sysInspectionPlan.setStatus(1); //默认为1.启用
            //添加巡检计划信息
            int insert = sysInspectionPlanDao.insert(sysInspectionPlan);
            if (insert <= 0){
                map.put("message","添加巡检计划失败");
            }
            //根据巡检路线主键id查询持续时间信息
            int spaceTime = sysInspectionRouteDao.findSpaceTimeById(sysInspectionPlan.getInspectionRouteId());

            //添加第一次执行巡检信息
            SysInspectionExecute sysInspectionExecute = new SysInspectionExecute();
            sysInspectionExecute.setInspectionPlanId(sysInspectionPlan.getId()); //填入巡检计划主键id
            sysInspectionExecute.setBeginDate(sysInspectionPlan.getPlanBeginDate()); //填入计划当次巡检开始时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sysInspectionPlan.getPlanBeginDate());
            calendar.add(Calendar.MINUTE,spaceTime);
            Date time = calendar.getTime();
            sysInspectionExecute.setEndDate(time);//填入计划当次巡检结束时间
            sysInspectionExecute.setSort(1);//填入排序默认为1
            //添加第一次执行巡检信息
            int insert2 = sysInspectionPlanDao.insertExecute(sysInspectionExecute);
            if (insert2 <=0){
                map.put("message","添加第一次执行巡检信息失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        //根据巡检计划主键id查询巡检计划信息
        VoFBIInspectionPlan voFBIInspectionPlan = sysInspectionPlanDao.findById(id);
        map.put("data",voFBIInspectionPlan);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据巡检计划主键id查询巡检计划状态
                int status = sysInspectionPlanDao.findStatusById(id);
                if (status == 1){
                    throw new RuntimeException("请先禁用该计划，才可删除");
                }
                //假删除巡检计划
                int update = sysInspectionPlanDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除失败");
                }
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        String msg = "";
        try {
            //根据巡检计划主键id查询巡检计划状态
            int status = sysInspectionPlanDao.findStatusById(id);
            if (status == 1){
                status = 2;
                msg = "停用";
            }else {
                //判断是否需要添加巡检执行情况信息
                //查询最新的一次计划当次巡检开始时间
                SysInspectionExecute sysInspectionExecute = sysInspectionPlanDao.findNewPlan(id);
                //根据巡检计划主键id 查询 巡检计划情况
                SysInspectionPlan sysInspectionPlan = butlerInspectionDao.findPlanById(sysInspectionExecute.getInspectionPlanId());
                if (sysInspectionExecute.getActualEndDate() != null){//如果实际当次巡检结束时间不为null,则添加一条巡检执行情况
                    //添加巡检执行情况信息
                    //添加下一条巡检计划
                    SysInspectionExecute sysInspectionExecute2 = new SysInspectionExecute();
                    sysInspectionExecute2.setInspectionPlanId(sysInspectionExecute.getInspectionPlanId()); //填入巡检计划主键id

                    Calendar calendar = Calendar.getInstance();
                    Date time = sysInspectionExecute.getBeginDate();
                    while (time.getTime() < new Date().getTime()){ //获取离当前时间最近的计划开始时间，当计划开始时间大于等于当前时间，跳出当前循环
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
                                throw new RuntimeException("数据异常");
                        }
                        time = calendar.getTime();
                    }

                    sysInspectionExecute2.setBeginDate(time); //填入计划当次巡检开始时间
                    //根据巡检路线主键id查询 持续时间
                    Integer spaceTime = butlerInspectionDao.findSpaceTimeById(sysInspectionPlan.getInspectionRouteId());
                    if (spaceTime == null){
                        throw new RuntimeException("数据异常2");
                    }
                    calendar.setTime(time);
                    calendar.add(Calendar.MINUTE,spaceTime);
                    Date time2 = calendar.getTime();
                    sysInspectionExecute2.setEndDate(time2); //填入计划当次巡检结束时间
                    //根据巡检计划主键id查询巡检执行数量
                    int count2 = butlerInspectionDao.countExecuteNumByPlanId(sysInspectionExecute.getInspectionPlanId());
                    sysInspectionExecute2.setSort(count2+1); //填入排序默认为1
                    int insert2 = sysInspectionPlanDao.insertExecute(sysInspectionExecute2);
                    if (insert2 <=0){
                        map.put("message","添加第一次执行巡检信息失败");
                    }
                }
                status = 1;
                msg = "启用";
            }
            PlanIdAndStatus planIdAndStatus = new PlanIdAndStatus();
            planIdAndStatus.setPlanId(id);
            planIdAndStatus.setStatus(status);
            int update = sysInspectionPlanDao.updateStatus(planIdAndStatus);
            if (update <= 0){
                throw new RuntimeException(msg+"失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message",msg+"成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoInspectionExecute> executeList(SearchInspectionExecute searchInspectionExecute) {
        List<VoInspectionExecute> list = sysInspectionPlanDao.executeList(searchInspectionExecute);
        List<SDInspectionExecutePointVo> executePointVoTotalList = systemDataDao.findExecutePointAll();

        if (list != null && list.size()>0){
            for (VoInspectionExecute inspectionExecuteVo : list) {
                //判断实际开始时间是否为null
                if (inspectionExecuteVo.getActualBeginDate() != null){
                    //判断实际结束时间是否为null
                    if (inspectionExecuteVo.getActualEndDate() != null){
                        inspectionExecuteVo.setStatus(2); //实际开始时间与实际结束时间都不为null，2.已巡检
                    }else {
                        inspectionExecuteVo.setStatus(3); //实际开始时间不为null,实际结束时间为null，3.巡检中
                    }
                }else {
                    //判断实际结束时间是否为null
                    if (inspectionExecuteVo.getActualEndDate() != null){
                        inspectionExecuteVo.setStatus(4); //实际开始时间为null,实际结束时间不为null，4.未巡检
                    }else {
                        //实际开始时间与实际结束时间都为null，1.待巡检
                        inspectionExecuteVo.setStatus(1);
                    }
                }

                List<SDInspectionExecutePointVo> executePointVos =null;
                //如果实际开始实际为null，查询执行计划的巡检点，反之，查询计划的巡检点
                if (inspectionExecuteVo.getActualBeginDate() != null){
                    //根据巡检执行计划主键id查询执行计划的巡检点（开始巡检后的巡检点信息）//TODO List.stream()
                    executePointVos = executePointVoTotalList.stream().filter(o -> o.getId().equals(inspectionExecuteVo.getId())).collect(Collectors.toList());
                }else {
                    //根据巡检执行计划主键id查询计划的巡检点（开始巡检前的巡检点信息）
                    executePointVos = systemDataDao.findPlanPointByExecuteId(inspectionExecuteVo.getId());
                }
                inspectionExecuteVo.setExecutePointVos(executePointVos);

                //巡检执行路线经纬度
                List<SDInspectionExecuteMapVo> executeMapVoList = systemDataDao.findAllLocation(inspectionExecuteVo.getId());
                inspectionExecuteVo.setExecuteMapVos(executeMapVoList);
            }
        }
        System.out.println(list);
        return list;
    }
}
