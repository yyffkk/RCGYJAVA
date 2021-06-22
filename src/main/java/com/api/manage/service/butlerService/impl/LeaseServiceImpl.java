package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.LeaseDao;
import com.api.manage.service.butlerService.LeaseService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLease;
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
public class LeaseServiceImpl implements LeaseService {
    private static Map<String,Object> map = null;
    @Resource
    LeaseDao leaseDao;

    @Override
    public List<VoLease> list(SearchLease searchLease) {
        return leaseDao.list(searchLease);
    }

    @Override
    public Map<String, Object> insert(SysLease sysLease) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysLease.setCreateId(sysUser.getId());;
        sysLease.setCreateDate(new Date());
        sysLease.setStatus(1);//1.待签署

        int insert = leaseDao.insert(sysLease);
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

        VoFBILease voFBILease = leaseDao.findById(id);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBILease);
        return map;
    }

    @Override
    public Map<String, Object> update(SysLease sysLease) {
        map = new HashMap<>();

        VoFBILease byId = leaseDao.findById(sysLease.getId());
        if (byId.getStatus() != 1){
            map.put("message","该状态不允许修改信息");
            map.put("status",false);
            return map;
        }

        int update = leaseDao.update(sysLease);
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
                VoFBILease byId = leaseDao.findById(id);
                if (byId.getStatus() != 1){
                    throw new RuntimeException("该状态不可删除");
                }

                int delete = leaseDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> reviewer(SysLease sysLease) {
        map = new HashMap<>();
        VoFBILease byId = leaseDao.findById(sysLease.getId());
        if (byId.getStatus() != 3){//3.审核中
            map.put("message","该状态不可审核");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysLease.setReviewer(sysUser.getId());
        sysLease.setAuditDate(new Date());

        int update = leaseDao.reviewer(sysLease);
        if (update >0 ){
            map.put("message","审核成功");
            map.put("status",true);
        }else {
            map.put("message","审核失败");
            map.put("status",false);
        }

        return map;
    }
}
