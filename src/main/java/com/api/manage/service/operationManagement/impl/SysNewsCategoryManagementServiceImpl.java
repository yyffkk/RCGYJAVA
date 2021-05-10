package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysNewsCategoryManagementDao;
import com.api.manage.service.operationManagement.SysNewsCategoryManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchNewsCategoryManagement;
import com.api.model.operationManagement.SysNewsCategoryManagement;
import com.api.util.IdWorker;
import com.api.vo.operationManagement.VoNewsCategoryManagement;
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
public class SysNewsCategoryManagementServiceImpl implements SysNewsCategoryManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysNewsCategoryManagementDao sysNewsCategoryManagementDao;

    @Override
    public List<VoNewsCategoryManagement> list(SearchNewsCategoryManagement searchNewsCategoryManagement) {
        return sysNewsCategoryManagementDao.list(searchNewsCategoryManagement);
    }

    @Override
    public Map<String, Object> insert(SysNewsCategoryManagement sysNewsCategoryManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysNewsCategoryManagement.setCreateId(sysUser.getId());
        sysNewsCategoryManagement.setCreateDate(new Date());
        sysNewsCategoryManagement.setNum(0); //资讯数量 默认初始为0
        sysNewsCategoryManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));

        int insert = sysNewsCategoryManagementDao.insert(sysNewsCategoryManagement);
        if (insert > 0){
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
        VoNewsCategoryManagement voNewsCategoryManagement = sysNewsCategoryManagementDao.findById(id);
        map.put("data",voNewsCategoryManagement);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> update(SysNewsCategoryManagement sysNewsCategoryManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysNewsCategoryManagement.setModifyId(sysUser.getId());
        sysNewsCategoryManagement.setModifyDate(new Date());

        int update = sysNewsCategoryManagementDao.update(sysNewsCategoryManagement);
        if (update > 0){
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
                int delete = sysNewsCategoryManagementDao.delete(id);
                if (delete <=0 ){
                    throw new RuntimeException("删除资讯分类失败");
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
        map.put("message","删除资讯分类成功");
        map.put("status",true);
        return map;
    }
}
