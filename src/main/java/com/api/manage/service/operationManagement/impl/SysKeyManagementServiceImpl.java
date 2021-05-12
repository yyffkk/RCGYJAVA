package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysKeyManagementDao;
import com.api.manage.service.operationManagement.SysKeyManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchKeyManagement;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.util.IdWorker;
import com.api.vo.operationManagement.VoKeyManagement;
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
public class SysKeyManagementServiceImpl implements SysKeyManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysKeyManagementDao sysKeyManagementDao;


    @Override
    public List<VoKeyManagement> list(SearchKeyManagement searchKeyManagement) {
        return sysKeyManagementDao.list(searchKeyManagement);
    }

    @Override
    public Map<String, Object> insert(SysKeyManagement sysKeyManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysKeyManagement.setCreateId(sysUser.getId());
        sysKeyManagement.setCreateDate(new Date());
        sysKeyManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));


        int insert = sysKeyManagementDao.insert(sysKeyManagement);
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
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoKeyManagement voKeyManagement = sysKeyManagementDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voKeyManagement);
        return map;
    }

    @Override
    public Map<String, Object> update(SysKeyManagement sysKeyManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysKeyManagement.setModifyId(sysUser.getId());
        sysKeyManagement.setModifyDate(new Date());

        int update = sysKeyManagementDao.update(sysKeyManagement);
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
                int delete = sysKeyManagementDao.delete(id);
                if (delete <=0){
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
