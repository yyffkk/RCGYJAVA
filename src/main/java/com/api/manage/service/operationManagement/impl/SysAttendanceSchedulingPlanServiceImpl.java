package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAttendanceSchedulingPlanDao;
import com.api.manage.service.operationManagement.SysAttendanceSchedulingPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchAttendanceSchedulingPlan;
import com.api.model.operationManagement.SysAttendanceSchedulingPlan;
import com.api.vo.operationManagement.VoAttendanceSchedulingPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

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

    @Override
    public List<VoAttendanceSchedulingPlan> list(SearchAttendanceSchedulingPlan searchAttendanceSchedulingPlan) {
        return sysAttendanceSchedulingPlanDao.list(searchAttendanceSchedulingPlan);
    }

    @Override
    public Map<String, Object> insert(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysAttendanceSchedulingPlan.setCreateId(sysUser.getId());
        sysAttendanceSchedulingPlan.setCreateDate(new Date());

        int insert = sysAttendanceSchedulingPlanDao.insert(sysAttendanceSchedulingPlan);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }
}
