package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysElectronicCommerceDao;
import com.api.manage.service.operationManagement.SysElectronicCommerceService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchElectronicCommerce;
import com.api.model.operationManagement.SysElectronicCommerce;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoElectronicCommerce;
import com.api.vo.operationManagement.VoFBIElectronicCommerce;
import com.api.vo.operationManagement.VoFBINewsManagement;
import com.api.vo.resources.VoResourcesImg;
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
public class SysElectronicCommerceServiceImpl implements SysElectronicCommerceService {
    private static Map<String,Object> map = null;
    @Resource
    SysElectronicCommerceDao sysElectronicCommerceDao;

    @Override
    public List<VoElectronicCommerce> list(SearchElectronicCommerce searchElectronicCommerce) {
        return sysElectronicCommerceDao.list(searchElectronicCommerce);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysElectronicCommerce sysElectronicCommerce) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysElectronicCommerce.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
            sysElectronicCommerce.setCreateId(sysUser.getId());
            sysElectronicCommerce.setCreateDate(new Date());

            int insert = sysElectronicCommerceDao.insert(sysElectronicCommerce);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }
            //添加照片
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysElectronicCommerce.getImgUrls(),"sysElectronicCommerce",sysElectronicCommerce.getId(),"electronicCommerceImg","600",20,30);


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

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIElectronicCommerce voFBIElectronicCommerce = sysElectronicCommerceDao.findById(id);
        if (voFBIElectronicCommerce != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysElectronicCommerce", voFBIElectronicCommerce.getId(), "electronicCommerceImg");
            voFBIElectronicCommerce.setImgList(imgByDate);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBIElectronicCommerce);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysElectronicCommerce sysElectronicCommerce) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysElectronicCommerce.setModifyId(sysUser.getId());
            sysElectronicCommerce.setModifyDate(new Date());

            int update = sysElectronicCommerceDao.update(sysElectronicCommerce);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysElectronicCommerce",sysElectronicCommerce.getId(),"electronicCommerceImg");
            uploadUtil.saveUrlToDB(sysElectronicCommerce.getImgUrls(),"sysElectronicCommerce",sysElectronicCommerce.getId(),"electronicCommerceImg","600",20,30);
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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            for (int id : ids) {
                VoFBIElectronicCommerce byId = sysElectronicCommerceDao.findById(id);
                if (byId == null){
                    throw new RuntimeException("删除电子商务信息失败,电子商务信息不存在");
                }

                int delete = sysElectronicCommerceDao.delete(id);
                if (delete <=0 ){
                    throw new RuntimeException("删除电子商务信息失败");
                }
                uploadUtil.delete("sysElectronicCommerce",id,"electronicCommerceImg");
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
        map.put("message","删除电子商务信息成功");
        map.put("status",true);
        return map;
    }
}
