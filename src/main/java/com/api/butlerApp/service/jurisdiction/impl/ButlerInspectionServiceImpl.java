package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.model.butlerApp.ButlerExecuteCheck;
import com.api.model.butlerApp.ButlerExecuteIdAndBeginDate;
import com.api.model.butlerApp.ButlerExecutePoint;
import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerInspectionServiceImpl implements ButlerInspectionService {
    @Resource
    ButlerInspectionDao butlerInspectionDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch) {
        return butlerInspectionDao.list(butlerInspectionSearch);
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
            ButlerExecuteIdAndBeginDate butlerExecuteIdAndBeginDate = new ButlerExecuteIdAndBeginDate();
            butlerExecuteIdAndBeginDate.setExecuteId(executeId);
            butlerExecuteIdAndBeginDate.setActualBeginDate(new Date());
            //修改当前巡检执行情况的实际开始时间
            int update = butlerInspectionDao.updateActualBeginDateById(butlerExecuteIdAndBeginDate);
            if (update <= 0){
                throw new RuntimeException("修改当前巡检执行情况失败");
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
