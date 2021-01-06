package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysWorkOrderTimeLimitDao;
import com.api.model.butlerService.SysWorkOrderTimeLimit;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysWorkOrderTimeLimitService;
import com.api.vo.butlerService.VoWorkOrderTimeLimit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysWorkOrderTimeLimitServiceImpl implements SysWorkOrderTimeLimitService {
    private static Map<String,Object> map = null;
    @Resource
    SysWorkOrderTimeLimitDao sysWorkOrderTimeLimitDao;

    @Override
    public List<VoWorkOrderTimeLimit> list() {
        return sysWorkOrderTimeLimitDao.list();
    }

    @Override
    public Map<String, Object> insert(SysWorkOrderTimeLimit sysWorkOrderTimeLimit) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人id
        sysWorkOrderTimeLimit.setCreateId(sysUser.getId());
        //填入创建时间
        sysWorkOrderTimeLimit.setCreateDate(new Date());
        //添加工单时限信息
        int insert = sysWorkOrderTimeLimitDao.insert(sysWorkOrderTimeLimit);
        if (insert > 0){
            map.put("message","添加工单时限成功");
            map.put("status",true);
        }else {
            map.put("message","添加工单时限失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoWorkOrderTimeLimit findById(Integer id) {
        return sysWorkOrderTimeLimitDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysWorkOrderTimeLimit sysWorkOrderTimeLimit) {
        map = new HashMap<>();
        try {
            //如果此工单时限信息已被引用，则不能更改信息
//        throw new RuntimeException("此工单时限信息已被引用，不能更改工单时限信息");

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //填入修改人id
            sysWorkOrderTimeLimit.setModifyId(sysUser.getId());
            //填入修改时间
            sysWorkOrderTimeLimit.setModifyDate(new Date());
            //更新工单时限信息
            int update = sysWorkOrderTimeLimitDao.update(sysWorkOrderTimeLimit);
            if (update <= 0 ){
                throw new RuntimeException("更新工单时限信息失败");
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
        map.put("message","更新工单时限信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length > 0){
                for (int id : ids) {
                    //如果此工单时限信息已被引用，则不能删除信息
//        throw new RuntimeException("此工单时限信息已被引用，不能删除工单时限信息");

                    //删除工单时限信息
                    int delete = sysWorkOrderTimeLimitDao.delete(id);
                    if (delete <= 0){
                        throw new RuntimeException("删除工单时限信息失败");
                    }
                }
            }else {
                throw new RuntimeException("请选择至少一项工单时限信息");
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
        map.put("message","删除工单时限信息成功");
        map.put("status",true);
        return map;
    }
}
