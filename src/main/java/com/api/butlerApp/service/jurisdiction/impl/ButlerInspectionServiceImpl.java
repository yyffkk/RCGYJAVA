package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.model.butlerApp.*;
import com.api.model.butlerService.SysInspectionExecute;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.*;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerInspectionServiceImpl implements ButlerInspectionService {
    @Resource
    ButlerInspectionDao butlerInspectionDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    @Resource
    SysInspectionPlanDao sysInspectionPlanDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch) {
        List<ButlerInspectionVo> list = butlerInspectionDao.list(butlerInspectionSearch);
        if (list != null && list.size()>0){
            for (ButlerInspectionVo butlerInspectionVo : list) {
                //判断实际开始时间是否为null
                if (butlerInspectionVo.getActualBeginDate() != null){
                    //判断实际结束时间是否为null
                    if (butlerInspectionVo.getActualEndDate() != null){
                        butlerInspectionVo.setStatus(2); //实际开始时间与实际结束时间都不为null，2.已巡检
                    }else {
                        butlerInspectionVo.setStatus(3); //实际开始时间不为null,实际结束时间为null，3.巡检中
                    }
                }else {
                    //判断实际结束时间是否为null
                    if (butlerInspectionVo.getActualEndDate() != null){
                        butlerInspectionVo.setStatus(4); //实际开始时间为null,实际结束时间不为null，4.未巡检
                    }else {
                        //实际开始时间与实际结束时间都为null，1.待巡检
                        butlerInspectionVo.setStatus(1);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findDetailById(Integer executeId) {
        map = new HashMap<>();
        ButlerInspectionFDBIVo inspectionFDBIVo = butlerInspectionDao.findDetailById(executeId);
        map.put("data",inspectionFDBIVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findPointByPlanId(Integer planId) {
        map = new HashMap<>();
        List<ButlerPointVo> butlerPointVoList = butlerInspectionDao.findPointByPlanId(planId);
        if (butlerPointVoList != null && butlerPointVoList.size()>0){
            for (ButlerPointVo butlerPointVo : butlerPointVoList) {
                //根据巡检点主键id查询检查项（计划表）
                int checkNum = butlerInspectionDao.countCheckNumByPointId(butlerPointVo.getId());
                butlerPointVo.setCheckNum(checkNum);
            }
        }
        map.put("data",butlerPointVoList);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findPointByExecuteId(Integer executeId) {
        map = new HashMap<>();
        List<ButlerPointVo> butlerPointVoList = butlerInspectionDao.findPointByExecuteId(executeId);
        if (butlerPointVoList != null && butlerPointVoList.size()>0){
            for (ButlerPointVo butlerPointVo : butlerPointVoList) {
                //根据巡检点主键id查询检查项（执行表）
                int checkNum = butlerInspectionDao.countCheckNumByPointId2(butlerPointVo.getId());
                butlerPointVo.setCheckNum(checkNum);
            }
        }
        map.put("data",butlerPointVoList);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> startInspection(Integer executeId, String roleId) {
        map = new HashMap<>();
        try {
            //查询用户所属权限,type:1.巡检人员 3.其他角色
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("无权限操作");
            }
            //判断是否可以点击开始巡检
            //根据巡检执行情况主键id查询巡检执行情况信息
            ButlerInspectionFDBIVo detailById = butlerInspectionDao.findDetailById(executeId);
            if (detailById.getActualBeginDate() != null){
                throw new RuntimeException("已开始巡检，操作失败");
            }

            if (new Date().getTime() < detailById.getBeginDate().getTime()){
                throw new RuntimeException("巡检未开始");
            }

            if (new Date().getTime() > detailById.getEndDate().getTime()){
                throw new RuntimeException("巡检已结束");
            }

            //查询计划巡检点信息，返回主键id
            List<ButlerExecutePoint> butlerExecutePointList = butlerInspectionDao.findPlanInspectionPoint(executeId);
            if (butlerExecutePointList != null && butlerExecutePointList.size()>0){
                for (ButlerExecutePoint butlerExecutePoint : butlerExecutePointList) {
                    //根据计划巡检点主键查询计划巡检点检查项
                    List<ButlerExecuteCheck> checkList = butlerInspectionDao.findPlanPointCheck(butlerExecutePoint.getId());

                    //添加执行巡检点信息
                    butlerExecutePoint.setId(null); //将执行巡检点主键id置为null
                    butlerExecutePoint.setExecuteId(executeId); //填入巡检执行情况主键id
                    int insert = butlerInspectionDao.insertExecutePoint(butlerExecutePoint);
                    if (insert <= 0){
                        throw new RuntimeException("添加执行巡检点失败");
                    }

                    if (checkList != null && checkList.size()>0){
                        for (ButlerExecuteCheck executeCheck : checkList) {
                            executeCheck.setExecutePointId(butlerExecutePoint.getId());
                            //添加执行巡检点检查项
                            int insert2 = butlerInspectionDao.insertExecuteCheck(executeCheck);
                            if (insert2 <=0){
                                throw new RuntimeException("添加执行巡检点检查项失败");
                            }
                        }
                    }

                }
            }
            //修改当前巡检执行情况的实际开始时间
            ButlerExecuteIdAndBeginDate butlerExecuteIdAndBeginDate = new ButlerExecuteIdAndBeginDate();
            butlerExecuteIdAndBeginDate.setExecuteId(executeId);
            butlerExecuteIdAndBeginDate.setActualBeginDate(new Date());
            int update = butlerInspectionDao.updateActualBeginDateById(butlerExecuteIdAndBeginDate);
            if (update <= 0){
                throw new RuntimeException("修改当前巡检执行情况失败");
            }
            if (detailById.getSort() ==1){
                //修改当前巡检计划的实际开始时间
                ButlerPlanIdAndActualBeginDate planIdAndActualBeginDate = new ButlerPlanIdAndActualBeginDate();
                planIdAndActualBeginDate.setPlanId(detailById.getInspectionPlanId());
                planIdAndActualBeginDate.setActualBeginDate(new Date());
                int update2 = butlerInspectionDao.updatePlanByPlanId(planIdAndActualBeginDate);
                if (update2 <= 0){
                    throw new RuntimeException("修改当前巡检计划的实际开始时间失败");
                }
            }

        } catch (RuntimeException e) {
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
        map.put("message","开始巡检成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findCheckDetailByQR(Integer executeId, Integer executePointId, String roleId) {
        map = new HashMap<>();
        //查询用户所属权限,type:1.巡检人员 3.其他角色
        int type = findJurisdictionByUserId(roleId);
        if (type != 1){
            map.put("data",null);
            map.put("message","无权限操作");
            map.put("status",false);
            return map;
        }
        //根据巡检执行情况主键id查询巡检点主键id
        List<Integer> ids = butlerInspectionDao.findPointIdByExecuteId(executeId);
        if (ids.contains(executePointId)){
            //显示信息
            ButlerExecutePointVo executePointVo = butlerInspectionDao.findExecutePointById(executePointId);
            if (executePointVo != null){
                List<ButlerExecuteCheckVo> checkVoList = butlerInspectionDao.findExecuteCheckByPointId(executePointVo.getId());
                executePointVo.setCheckVoList(checkVoList);
            }
            map.put("data",executePointVo);
            map.put("message","请求成功");
            map.put("status",true);
        }else {
            map.put("data",null);
            map.put("message","所扫二维码信息与执行任务不符合");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitPointDetail(ButlerExecutePointSubmit executePointSubmit, String roleId) {
        map = new HashMap<>();
        try {
            //查询该巡检点是否已被执行
            ButlerExecutePoint butlerExecutePoint = butlerInspectionDao.findCompleteDateById(executePointSubmit.getExecutePointId());
            if (butlerExecutePoint.getCompleteDate() != null){
                throw new RuntimeException("该巡检点已执行");
            }
            //修改巡检执行点检查项
            List<ButlerExecuteCheck> executeCheckList = executePointSubmit.getExecuteCheckList();
            if (executeCheckList != null && executeCheckList.size()>0){
                for (ButlerExecuteCheck executeCheck : executeCheckList) {
                    executeCheck.setExecutePointId(executePointSubmit.getExecutePointId());
                    int update = butlerInspectionDao.updateExecuteCheck(executeCheck);
                    if (update <=0){
                        throw new RuntimeException("修改巡检执行点检查项失败");
                    }
                }
            }
            UploadUtil uploadUtil = new UploadUtil();
            //上传自拍照片
            uploadUtil.saveUrlToDB(executePointSubmit.getInspectionFaceImg(),"sysInspectionExecutePoint",executePointSubmit.getExecutePointId(),"inspectionFace","600",30,20);
            //上传现场照片
            uploadUtil.saveUrlToDB(executePointSubmit.getInspectionSpaceImg(),"sysInspectionExecutePoint",executePointSubmit.getExecutePointId(),"inspectionSpace","600",30,20);
            ButlerPointIdAndCompleteDate pointIdAndCompleteDate = new ButlerPointIdAndCompleteDate();
            pointIdAndCompleteDate.setPointId(executePointSubmit.getExecutePointId());
            pointIdAndCompleteDate.setCompleteDate(new Date());
            //更新巡检点完成时间
            int update = butlerInspectionDao.updateExecutePoint(pointIdAndCompleteDate);
            if (update <= 0){
                throw new RuntimeException("修改巡检点完成时间失败");
            }
            //判断巡检点是否全部完成
            int count = butlerInspectionDao.countExecutePoint(butlerExecutePoint.getExecuteId());
            if (count == 0){
                //修改当次巡检情况实际结束时间
                ButlerExecuteIdAndActualEndDate executeIdAndActualEndDate = new ButlerExecuteIdAndActualEndDate();
                executeIdAndActualEndDate.setExecuteId(butlerExecutePoint.getExecuteId());
                executeIdAndActualEndDate.setActualEndDate(new Date());
                int update3 = butlerInspectionDao.updateExecute(executeIdAndActualEndDate);
                if (update3 <= 0){
                    throw new RuntimeException("修改当次巡检情况实际结束时间失败");
                }
                //根据巡检执行情况主键id 查询 巡检执行情况
                SysInspectionExecute sysInspectionExecute = butlerInspectionDao.findExecuteByExecuteId(butlerExecutePoint.getExecuteId());
                //根据巡检计划主键id 查询 巡检计划情况
                SysInspectionPlan sysInspectionPlan = butlerInspectionDao.findPlanById(sysInspectionExecute.getInspectionPlanId());
                if (sysInspectionPlan.getStatus() ==1){ //启用
                    //添加下一条巡检计划
                    SysInspectionExecute sysInspectionExecute2 = new SysInspectionExecute();
                    sysInspectionExecute2.setInspectionPlanId(sysInspectionExecute.getInspectionPlanId()); //填入巡检计划主键id
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(sysInspectionExecute.getBeginDate());
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
                    Date time = calendar.getTime();
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

            }
        } catch (RuntimeException e) {
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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findCheckDetailById(Integer executePointId) {
        map = new HashMap<>();
        //根据巡检执行点主键id查询巡检执行点信息
        ButlerExecutePointFBIVo executePointFBIVo = butlerInspectionDao.findExecutePointById2(executePointId);
        if (executePointFBIVo != null){
            //根据巡检执行点主键id查询巡检执行检查项
            List<ButlerExecuteCheckFBIVo> checkFBIVoList = butlerInspectionDao.findExecuteCheckByPointId2(executePointId);
            executePointFBIVo.setCheckFBIVoList(checkFBIVoList);
            UploadUtil uploadUtil = new UploadUtil();
            //查询巡更人员自拍人脸
            List<VoResourcesImg> byDate1 = uploadUtil.findImgByDate("sysInspectionExecutePoint", executePointId, "inspectionFace");
            executePointFBIVo.setFaceImg(byDate1);
            //查询巡更人员拍摄现场
            List<VoResourcesImg> byDate2 = uploadUtil.findImgByDate("sysInspectionExecutePoint", executePointId, "inspectionSpace");
            executePointFBIVo.setSpaceImg(byDate2);
        }
        map.put("data",executePointFBIVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //63.巡检操作
                    if (jurisdictionIds.contains(63)){
                        return 1;
                    }
                }
            }
        }
        return 3;
    }
}
