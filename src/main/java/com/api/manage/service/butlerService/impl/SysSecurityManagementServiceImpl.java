package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysSecurityManagementDao;
import com.api.manage.service.butlerService.SysSecurityManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchSecurityManagement;
import com.api.model.butlerService.SecurityManagement;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.butlerService.VoFBISecurityManagement;
import com.api.vo.butlerService.VoSecurityManagement;
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
public class SysSecurityManagementServiceImpl implements SysSecurityManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysSecurityManagementDao sysSecurityManagementDao;

    @Override
    public List<VoSecurityManagement> list(SearchSecurityManagement searchSecurityManagement) {
        List<VoSecurityManagement> list = sysSecurityManagementDao.list(searchSecurityManagement);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (VoSecurityManagement voSecurityManagement : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysSecurityManagement", voSecurityManagement.getId(), "fileImg");
                voSecurityManagement.setImgList(imgByDate);
            }
        }

        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SecurityManagement securityManagement) {
        map = new HashMap<>();

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            securityManagement.setCreateId(sysUser.getId());//填入创建人id
            securityManagement.setCreateDate(new Date());//填入创建时间
            securityManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));

            int insert = sysSecurityManagementDao.insert(securityManagement);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(securityManagement.getImgUrls(),"sysSecurityManagement",securityManagement.getId(),"fileImg","600",30,20);

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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findAllCreateName() {
        map = new HashMap<>();

        List<VoFindAll> voFindAllList = sysSecurityManagementDao.findAllCreateName();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFindAllList);

        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();

        VoFBISecurityManagement voFBISecurityManagement = sysSecurityManagementDao.findById(id);
        if (voFBISecurityManagement != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysSecurityManagement", voFBISecurityManagement.getId(), "fileImg");
            voFBISecurityManagement.setImgList(imgByDate);
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBISecurityManagement);


        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SecurityManagement securityManagement) {
        map = new HashMap<>();

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            securityManagement.setModifyId(sysUser.getId());//填入修改人id
            securityManagement.setModifyDate(new Date());//填入修改时间

            int update = sysSecurityManagementDao.update(securityManagement);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片信息
            uploadUtil.delete("sysSecurityManagement",securityManagement.getId(),"fileImg");
            //再添加照片信息
            uploadUtil.saveUrlToDB(securityManagement.getImgUrls(),"sysSecurityManagement",securityManagement.getId(),"fileImg","600",30,20);

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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }
}
