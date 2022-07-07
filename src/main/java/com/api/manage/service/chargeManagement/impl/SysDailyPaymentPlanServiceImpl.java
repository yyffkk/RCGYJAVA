package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysDailyPaymentPlanDao;
import com.api.manage.service.chargeManagement.SysDailyPaymentPlanService;
import com.api.model.businessManagement.SysUser;
import com.api.model.chargeManagement.DailyPaymentPlan;
import com.api.model.chargeManagement.SearchDailyPaymentPlan;
import com.api.vo.chargeManagement.VoDailyPaymentPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDailyPaymentPlanServiceImpl implements SysDailyPaymentPlanService {
    private static Map<String,Object> map = null;
    @Resource
    SysDailyPaymentPlanDao sysDailyPaymentPlanDao;

    @Override
    public List<VoDailyPaymentPlan> list(SearchDailyPaymentPlan searchDailyPaymentPlan) {
        return sysDailyPaymentPlanDao.list(searchDailyPaymentPlan);
    }

    @Override
    public Map<String, Object> insert(DailyPaymentPlan dailyPaymentPlan) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        dailyPaymentPlan.setCreateId(sysUser.getId());
        dailyPaymentPlan.setCreateDate(new Date());
        dailyPaymentPlan.setIsDelete(1);//默认填1.非删
        dailyPaymentPlan.setCostPrice(dailyPaymentPlan.getUnitPrice().multiply(new BigDecimal(dailyPaymentPlan.getNum())).setScale(2,BigDecimal.ROUND_HALF_UP));

        int insert = sysDailyPaymentPlanDao.insert(dailyPaymentPlan);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> update(DailyPaymentPlan dailyPaymentPlan) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        dailyPaymentPlan.setModifyId(sysUser.getId());
        dailyPaymentPlan.setModifyDate(new Date());
        dailyPaymentPlan.setCostPrice(dailyPaymentPlan.getUnitPrice().multiply(new BigDecimal(dailyPaymentPlan.getNum())).setScale(2,BigDecimal.ROUND_HALF_UP));

        int update = sysDailyPaymentPlanDao.update(dailyPaymentPlan);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysDailyPaymentPlanDao.delete(id);
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
}
