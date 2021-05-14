package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysNewsCategoryManagementDao;
import com.api.manage.dao.operationManagement.SysNewsManagementDao;
import com.api.manage.service.operationManagement.SysNewsCategoryManagementService;
import com.api.manage.service.operationManagement.SysNewsManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchNewsManagement;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoFBINewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;
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
public class SysNewsManagementServiceImpl implements SysNewsManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysNewsManagementDao sysNewsManagementDao;
    @Resource
    SysNewsCategoryManagementDao sysNewsCategoryManagementDao;

    @Override
    public List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement) {
        return sysNewsManagementDao.list(searchNewsManagement);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysNewsManagement sysNewsManagement) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysNewsManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
            sysNewsManagement.setCreateId(sysUser.getId());
            sysNewsManagement.setCreateDate(new Date());

            int insert = sysNewsManagementDao.insert(sysNewsManagement);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }
            //添加照片
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysNewsManagement.getImgUrls(),"sysNews",sysNewsManagement.getId(),"newsImg","600",20,30);

            //对资讯分类的资讯数量进行累加
            int update = sysNewsCategoryManagementDao.incNum(sysNewsManagement.getNewsCategoryId());
            if (update <= 0){
                throw new RuntimeException("累加失败");
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer newsId) {
        map = new HashMap<>();
        VoFBINewsManagement voFBINewsManagement = sysNewsManagementDao.findById(newsId);
        if (voFBINewsManagement != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", voFBINewsManagement.getId(), "newsImg");
            voFBINewsManagement.setImgList(imgByDate);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBINewsManagement);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysNewsManagement sysNewsManagement) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysNewsManagement.setModifyId(sysUser.getId());
            sysNewsManagement.setModifyDate(new Date());

            int update = sysNewsManagementDao.update(sysNewsManagement);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysNews",sysNewsManagement.getId(),"newsImg");
            uploadUtil.saveUrlToDB(sysNewsManagement.getImgUrls(),"sysNews",sysNewsManagement.getId(),"newsImg","600",20,30);
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
                VoFBINewsManagement byId = sysNewsManagementDao.findById(id);
                if (byId == null){
                    throw new RuntimeException("删除资讯失败,资讯不存在");
                }

                //对资讯分类的资讯数量进行累减
                int update = sysNewsCategoryManagementDao.decNum(byId.getNewsCategoryId());
                if (update <= 0){
                    throw new RuntimeException("累减失败");
                }

                int delete = sysNewsManagementDao.delete(id);
                if (delete <=0 ){
                    throw new RuntimeException("删除资讯失败");
                }
                uploadUtil.delete("sysNews",id,"newsImg");
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
        map.put("message","删除资讯成功");
        map.put("status",true);
        return map;
    }
}
