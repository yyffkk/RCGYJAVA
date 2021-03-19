package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.manage.service.butlerService.SysInspectionPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionExecute;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoInspectionPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysInspectionPlanServiceImpl implements SysInspectionPlanService {
    @Resource
    SysInspectionPlanDao sysInspectionPlanDao;
    private static Map<String,Object> map = null;


    @Override
    public List<VoInspectionPlan> list(SearchInspectionPlan searchInspectionPlan) {
        return sysInspectionPlanDao.list(searchInspectionPlan);
    }

    @Override
    public Map<String, Object> insert(SysInspectionPlan sysInspectionPlan) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        sysInspectionPlan.setCreateId(sysUser.getId()); //填入创建人id
        sysInspectionPlan.setCreateDate(new Date()); //填入创建时间
        sysInspectionPlan.setIsDelete(1); //默认为1.删除
        sysInspectionPlan.setCode(UUID.randomUUID().toString().replace("-","").trim()); //填入巡检计划编号
        sysInspectionPlan.setStatus(1); //默认为1.启用
        //添加巡检计划信息
        int insert = sysInspectionPlanDao.insert(sysInspectionPlan);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        //添加第一次执行巡检信息 //?????
        SysInspectionExecute sysInspectionExecute = new SysInspectionExecute();



        return map;
    }
}
