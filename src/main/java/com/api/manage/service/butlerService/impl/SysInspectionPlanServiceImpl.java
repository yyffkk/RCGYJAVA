package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionPlanDao;
import com.api.manage.dao.butlerService.SysInspectionRouteDao;
import com.api.manage.service.butlerService.SysInspectionPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionExecute;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoInspectionPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysInspectionPlanServiceImpl implements SysInspectionPlanService {
    @Resource
    SysInspectionPlanDao sysInspectionPlanDao;
    @Resource
    SysInspectionRouteDao sysInspectionRouteDao;
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
            sysInspectionPlan.setCode(UUID.randomUUID().toString().replace("-","").trim()); //填入巡检计划编号
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
}
