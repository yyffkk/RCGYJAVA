package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAttendanceSchedulingPlanDao;
import com.api.manage.dao.operationManagement.SysAttendanceTeamDao;
import com.api.manage.service.operationManagement.SysAttendanceSchedulingPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.*;
import com.api.vo.operationManagement.VoAttendanceSchedulingPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysAttendanceSchedulingPlanServiceImpl implements SysAttendanceSchedulingPlanService {
    private static Map<String,Object> map = null;
    @Resource
    SysAttendanceSchedulingPlanDao sysAttendanceSchedulingPlanDao;
    @Resource
    SysAttendanceTeamDao sysAttendanceTeamDao;

    @Override
    public List<VoAttendanceSchedulingPlan> list(SearchAttendanceSchedulingPlan searchAttendanceSchedulingPlan) {
        return sysAttendanceSchedulingPlanDao.list(searchAttendanceSchedulingPlan);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan) {
        map = new HashMap<>();

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysAttendanceSchedulingPlan.setCreateId(sysUser.getId());
            sysAttendanceSchedulingPlan.setCreateDate(new Date());

            //添加考勤排班计划
            int insert = sysAttendanceSchedulingPlanDao.insert(sysAttendanceSchedulingPlan);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            //添加考勤排班计划详情
            List<SysAttendanceSchedulingPlanDetail> planDetails = sysAttendanceSchedulingPlan.getSysAttendanceSchedulingPlanDetails();
            if (planDetails != null && planDetails.size() >0){
                for (SysAttendanceSchedulingPlanDetail planDetail : planDetails) {
                    planDetail.setAttendanceSchedulingPlanId(sysAttendanceSchedulingPlan.getId());
                    int insert2 = sysAttendanceSchedulingPlanDao.insertDetail(planDetail);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加详情失败");
                    }
                }
            }

            //添加考勤排班计划例外情况
            List<SysAttendanceSchedulingPlanException> planExceptionList = sysAttendanceSchedulingPlan.getSysAttendanceSchedulingPlanExceptionList();
            if (planExceptionList != null && planExceptionList.size()>0){
                for (SysAttendanceSchedulingPlanException planException : planExceptionList) {
                    planException.setAttendanceSchedulingPlanId(sysAttendanceSchedulingPlan.getId());
                    int insert3 = sysAttendanceSchedulingPlanDao.insertException(planException);
                    if (insert3 <= 0){
                        throw new RuntimeException("添加例外情况失败");
                    }
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            for (int id : ids) {
                //根据考勤排班计划主键id查询考勤排班计划
                SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan = sysAttendanceSchedulingPlanDao.findById(id);
                if (sysAttendanceSchedulingPlan.getStatus() == 1){
                    throw new RuntimeException("该计划已启用，请先停用");
                }
                //根据考勤排班计划主键id删除考勤排班计划例外情况
                int delete = sysAttendanceSchedulingPlanDao.deleteException(id);
                if (delete <= 0){
                    throw new RuntimeException("删除例外情况失败");
                }
                //根据考勤排班计划主键id删除考勤排班计划详情
                int delete2 = sysAttendanceSchedulingPlanDao.deleteDetail(id);
                if (delete2 <= 0){
                    throw new RuntimeException("删除详情失败");
                }
                //根据考勤排班计划主键id删除考勤排班计划
                int delete3 = sysAttendanceSchedulingPlanDao.delete(id);
                if (delete3 <= 0){
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
    @Transactional
    public Map<String, Object> update(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan) {
        map = new HashMap<>();

        try {
            //根据考勤排班计划主键id查询考勤排班计划
            SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan2 = sysAttendanceSchedulingPlanDao.findById(sysAttendanceSchedulingPlan.getId());
            if (sysAttendanceSchedulingPlan2.getStatus() == 1){
                throw new RuntimeException("该计划已启用，请先停用");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysAttendanceSchedulingPlan.setModifyId(sysUser.getId());
            sysAttendanceSchedulingPlan.setModifyDate(new Date());

            //先根据考勤排班计划主键id 修改 考勤排班计划
            int update = sysAttendanceSchedulingPlanDao.update(sysAttendanceSchedulingPlan);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            //再修改考勤排班计划其他信息
            //先删除
            //根据考勤排班计划主键id删除考勤排班计划例外情况
            int delete = sysAttendanceSchedulingPlanDao.deleteException(sysAttendanceSchedulingPlan.getId());
            if (delete <= 0){
                throw new RuntimeException("删除例外情况失败");
            }
            //根据考勤排班计划主键id删除考勤排班计划详情
            int delete2 = sysAttendanceSchedulingPlanDao.deleteDetail(sysAttendanceSchedulingPlan.getId());
            if (delete2 <= 0){
                throw new RuntimeException("删除详情失败");
            }
            //再添加
            //添加考勤排班计划详情
            List<SysAttendanceSchedulingPlanDetail> planDetails = sysAttendanceSchedulingPlan.getSysAttendanceSchedulingPlanDetails();
            if (planDetails != null && planDetails.size() >0){
                for (SysAttendanceSchedulingPlanDetail planDetail : planDetails) {
                    planDetail.setAttendanceSchedulingPlanId(sysAttendanceSchedulingPlan.getId());
                    int insert2 = sysAttendanceSchedulingPlanDao.insertDetail(planDetail);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加详情失败");
                    }
                }
            }

            //添加考勤排班计划例外情况
            List<SysAttendanceSchedulingPlanException> planExceptionList = sysAttendanceSchedulingPlan.getSysAttendanceSchedulingPlanExceptionList();
            if (planExceptionList != null && planExceptionList.size()>0){
                for (SysAttendanceSchedulingPlanException planException : planExceptionList) {
                    planException.setAttendanceSchedulingPlanId(sysAttendanceSchedulingPlan.getId());
                    int insert3 = sysAttendanceSchedulingPlanDao.insertException(planException);
                    if (insert3 <= 0){
                        throw new RuntimeException("添加例外情况失败");
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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> enable(Integer id) {
        map = new HashMap<>();
        String msg = "";
        try {
            SysAttendanceSchedulingPlan byId = sysAttendanceSchedulingPlanDao.findById(id);
            if (byId.getStatus() == 1){//1.启用
                msg = "停用";
                byId.setStatus(2);//填入状态：2.停用
                int update = sysAttendanceSchedulingPlanDao.updateStatusById(byId);
                if (update <= 0){
                    throw new RuntimeException(msg+"失败");
                }
            }else {//2.停用
                //先根据考勤小组主键id查询考勤人员
                SysAttendanceTeam sysAttendanceTeam = sysAttendanceTeamDao.findById(byId.getTeamId());
                //将小组成员id 字符串转数组【逗号分隔】
                String[] split = sysAttendanceTeam.getTeamMembers().split(",");

                //再根据考勤人员查询是否存在开启的排班计划
                for (String s : split) {
                    int count = sysAttendanceTeamDao.countPlanByUserId(s);
                    if (count >0 ){
                        String userName = sysAttendanceTeamDao.findUserNameById(s);
                        throw new RuntimeException("存在人员【"+userName+"】有开启的排班计划");
                    }
                }

                msg = "启用";
                byId.setStatus(1);//填入状态：1.启用
                int update = sysAttendanceSchedulingPlanDao.updateStatusById(byId);
                if (update <= 0){
                    throw new RuntimeException(msg+"失败");
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
        map.put("message",msg+"成功");
        map.put("status",true);
        return map;
    }
}
