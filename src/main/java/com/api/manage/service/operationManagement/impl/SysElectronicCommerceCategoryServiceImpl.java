package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysElectronicCommerceCategoryDao;
import com.api.manage.service.operationManagement.SysElectronicCommerceCategoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchElectronicCommerceCategory;
import com.api.model.operationManagement.SysElectronicCommerceCategory;
import com.api.util.IdWorker;
import com.api.vo.operationManagement.VoElectronicCommerceCategory;
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
public class SysElectronicCommerceCategoryServiceImpl implements SysElectronicCommerceCategoryService {
    private static Map<String,Object> map = null;
    @Resource
    SysElectronicCommerceCategoryDao sysElectronicCommerceCategoryDao;

    @Override
    public List<VoElectronicCommerceCategory> list(SearchElectronicCommerceCategory searchElectronicCommerceCategory) {
        return sysElectronicCommerceCategoryDao.list(searchElectronicCommerceCategory);
    }

    @Override
    public Map<String, Object> insert(SysElectronicCommerceCategory sysElectronicCommerceCategory) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysElectronicCommerceCategory.setCreateId(sysUser.getId());
        sysElectronicCommerceCategory.setCreateDate(new Date());
        sysElectronicCommerceCategory.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));

        int insert = sysElectronicCommerceCategoryDao.insert(sysElectronicCommerceCategory);
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
        VoElectronicCommerceCategory voElectronicCommerceCategory = sysElectronicCommerceCategoryDao.findById(id);
        map.put("data",voElectronicCommerceCategory);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> update(SysElectronicCommerceCategory sysElectronicCommerceCategory) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysElectronicCommerceCategory.setModifyId(sysUser.getId());
        sysElectronicCommerceCategory.setModifyDate(new Date());

        int update = sysElectronicCommerceCategoryDao.update(sysElectronicCommerceCategory);
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
                int delete = sysElectronicCommerceCategoryDao.delete(id);
                if (delete <=0 ){
                    throw new RuntimeException("删除电子商务分类失败");
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
        map.put("message","删除电子商务分类成功");
        map.put("status",true);
        return map;
    }
}
