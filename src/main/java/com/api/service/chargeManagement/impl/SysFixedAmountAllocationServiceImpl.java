package com.api.service.chargeManagement.impl;

import com.api.dao.chargeManagement.SysFixedAmountAllocationDao;
import com.api.model.chargeManagement.SearchFixedAmountAllocation;
import com.api.model.chargeManagement.SysFixedAmountAllocation;
import com.api.model.system.SysUser;
import com.api.service.chargeManagement.SysFixedAmountAllocationService;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
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
public class SysFixedAmountAllocationServiceImpl implements SysFixedAmountAllocationService {
    private static Map<String,Object> map = null;
    @Resource
    SysFixedAmountAllocationDao sysFixedAmountAllocationDao;

    @Override
    public List<VoFixedAmountAllocation> list(SearchFixedAmountAllocation searchFixedAmountAllocation) {
        return sysFixedAmountAllocationDao.list(searchFixedAmountAllocation);
    }

    @Override
    public Map<String, Object> insert(SysFixedAmountAllocation sysFixedAmountAllocation) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        sysFixedAmountAllocation.setCreateId(sysUser.getId());
        //填入创建时间
        sysFixedAmountAllocation.setCreateDate(new Date());
        //状态，初始为1.未分摊
        sysFixedAmountAllocation.setStatus(1);
        //是否删除，0.删除，1.非删
        sysFixedAmountAllocation.setIsDelete(1);
        //添加固定金额分摊信息
        int insert = sysFixedAmountAllocationDao.insert(sysFixedAmountAllocation);
        if (insert > 0){
            map.put("message","添加固定金额分摊信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加固定金额分摊信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdFAA findById(Integer id) {
        return sysFixedAmountAllocationDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysFixedAmountAllocation sysFixedAmountAllocation) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        sysFixedAmountAllocation.setModifyId(sysUser.getId());
        //填入修改时间
        sysFixedAmountAllocation.setModifyDate(new Date());
        int update = sysFixedAmountAllocationDao.update(sysFixedAmountAllocation);
        if (update >0){
            map.put("message","修改固定金额分摊信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改固定金额分摊信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //假删除固定金额分摊信息
                int update = sysFixedAmountAllocationDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除固定金额分摊信息失败");
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
        map.put("message","删除固定金额分摊信息成功");
        map.put("status",true);
        return map;
    }
}
