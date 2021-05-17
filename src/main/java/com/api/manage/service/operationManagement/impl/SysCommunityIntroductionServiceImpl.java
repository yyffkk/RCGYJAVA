package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysCommunityIntroductionDao;
import com.api.manage.service.operationManagement.SysCommunityIntroductionService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchCommunityIntroduction;
import com.api.model.operationManagement.SysCommunityIntroduction;
import com.api.vo.operationManagement.VoCommunityIntroduction;
import com.api.vo.operationManagement.VoFBICommunityIntroduction;
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
public class SysCommunityIntroductionServiceImpl implements SysCommunityIntroductionService {
    private static Map<String,Object> map = null;
    @Resource
    SysCommunityIntroductionDao sysCommunityIntroductionDao;

    @Override
    public List<VoCommunityIntroduction> list(SearchCommunityIntroduction searchCommunityIntroduction) {
        return sysCommunityIntroductionDao.list(searchCommunityIntroduction);
    }

    @Override
    public Map<String, Object> insert(SysCommunityIntroduction sysCommunityIntroduction) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysCommunityIntroduction.setCreateId(sysUser.getId());
        sysCommunityIntroduction.setCreateDate(new Date());
        sysCommunityIntroduction.setStatus(2);//默认填写，2.未启用

        int insert = sysCommunityIntroductionDao.insert(sysCommunityIntroduction);

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
        VoFBICommunityIntroduction voFBICommunityIntroduction = sysCommunityIntroductionDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBICommunityIntroduction);
        return map;
    }

    @Override
    public Map<String, Object> update(SysCommunityIntroduction sysCommunityIntroduction) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysCommunityIntroduction.setModifyId(sysUser.getId());
        sysCommunityIntroduction.setModifyDate(new Date());

        int update = sysCommunityIntroductionDao.update(sysCommunityIntroduction);
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
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = sysCommunityIntroductionDao.delete(id);
                if (delete <= 0){
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
    public Map<String, Object> enable(Integer id) {
        map = new HashMap<>();
        try {
            //启用当前社区介绍模版
            int update = sysCommunityIntroductionDao.enable(id);
            //禁用其他社区介绍模版
            int update2 = sysCommunityIntroductionDao.disableOther(id);
            if (update <= 0 || update2 <= 0){
                throw new RuntimeException("启用失败");
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
        map.put("message","启用成功");
        map.put("status",true);
        return map;
    }
}