package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAnnouncementManagementDao;
import com.api.model.operationManagement.ReleaseDateAndId;
import com.api.model.operationManagement.SearchAnnouncementManagement;
import com.api.model.operationManagement.SysAnnouncementManagement;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.operationManagement.SysAnnouncementManagementService;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoFindByIdAnnouncementManagement;
import com.api.vo.operationManagement.VoPreviewAnnouncementManagement;
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
public class SysAnnouncementManagementServiceImpl implements SysAnnouncementManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysAnnouncementManagementDao sysAnnouncementManagementDao;

    @Override
    public List<VoAnnouncementManagement> list(SearchAnnouncementManagement searchAnnouncementManagement) {
        List<VoAnnouncementManagement> list = sysAnnouncementManagementDao.list(searchAnnouncementManagement);
        if (list != null && list.size()>0){
            for (VoAnnouncementManagement voAnnouncementManagement : list) {
                //如果 状态为3 并且 定时发布时间小于或等于当前时间 ，则进行修改状态，并重新赋值，是否发布
                if (voAnnouncementManagement.getStatus() == 3 && voAnnouncementManagement.getScheduledReleaseTime().getTime()<=new Date().getTime()){
                    SysAnnouncementManagement sysAnnouncementManagement = new SysAnnouncementManagement();
                    //填入主键id
                    sysAnnouncementManagement.setId(voAnnouncementManagement.getId());
                    //填入发布时间，当前发布时间是定时发布时间
                    sysAnnouncementManagement.setReleaseDate(voAnnouncementManagement.getScheduledReleaseTime());
                    sysAnnouncementManagementDao.update(sysAnnouncementManagement);
                    //重新赋值,使前端正常显示
                    voAnnouncementManagement.setStatus(2);
                }
            }
        }
        return list;
    }

    @Override
    public VoFindByIdAnnouncementManagement findById(Integer id) {
        //根据主键id查询公告信息
        VoFindByIdAnnouncementManagement byId = sysAnnouncementManagementDao.findById(id);
        //查询照片信息
        UploadUtil uploadUtil = new UploadUtil();
        //传入照片信息
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", id, "announcementImg");
        byId.setImgUrls(imgByDate);
        return byId;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysAnnouncementManagement sysAnnouncementManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //填入创建人
            sysAnnouncementManagement.setCreateId(sysUser.getId());
            //填入创建时间
            sysAnnouncementManagement.setCreateDate(new Date());
            //填入阅读量（初始为0）
            sysAnnouncementManagement.setReadingVolume(0);
            //如果status为2.已发布,则填入发布时间
            if (sysAnnouncementManagement.getStatus() == 2){
                sysAnnouncementManagement.setReleaseDate(new Date());
            }
            //添加公告信息
            int insert = sysAnnouncementManagementDao.insert(sysAnnouncementManagement);
            if (insert <= 0){
                throw new RuntimeException("添加公告信息失败");
            }
            //上传照片文件到数据库
            uploadUtil.saveUrlToDB(sysAnnouncementManagement.getExcelFileUrls(),"sysAnnouncementManagement",sysAnnouncementManagement.getId(),"announcementImg","600",30,20);
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
        map.put("message","添加公告信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysAnnouncementManagement sysAnnouncementManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //当 状态为定时任务 并且 定时发布时间是否小于或等于当前时间 时，提示，当前公告已发布
            if (sysAnnouncementManagement.getStatus() == 3 && sysAnnouncementManagement.getScheduledReleaseTime().getTime() <= new Date().getTime()){
                throw new RuntimeException("当前公告已发布");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片信息
            uploadUtil.delete("sysAnnouncementManagement",sysAnnouncementManagement.getId(),"announcementImg");
            //再添加照片信息到数据库
            uploadUtil.saveUrlToDB(sysAnnouncementManagement.getExcelFileUrls(),"sysAnnouncementManagement",sysAnnouncementManagement.getId(),"announcementImg","600",30,20);
            //根据主键id查询公告信息
            VoFindByIdAnnouncementManagement byId = sysAnnouncementManagementDao.findById(sysAnnouncementManagement.getId());
            //先删除doc文件信息
            uploadUtil.deleteDoc(byId.getFileDocUrl());
            //填入修改人
            sysAnnouncementManagement.setModifyId(sysUser.getId());
            //填入修改时间
            sysAnnouncementManagement.setModifyDate(new Date());
            //如果[byId]原status为1，[sysAnnouncementManagement]现status为2.已发布,则填入发布时间
            if (sysAnnouncementManagement.getStatus() == 2 && byId.getStatus() == 1){
                sysAnnouncementManagement.setReleaseDate(new Date());
            }
            //修改公告信息
            int update = sysAnnouncementManagementDao.update(sysAnnouncementManagement);
            if (update <= 0){
                throw new RuntimeException("修改公告信息失败");
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
        map.put("message","修改公告信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            for (int id : ids) {
                //先删除照片信息
                uploadUtil.delete("sysAnnouncementManagement",id,"announcementImg");
                //根据主键id查询公告信息
                VoFindByIdAnnouncementManagement byId = sysAnnouncementManagementDao.findById(id);
                //再删除doc文件信息
                uploadUtil.deleteDoc(byId.getFileDocUrl());
                //根据主键id删除公告管理
                int delete = sysAnnouncementManagementDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除公告信息失败");
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
        map.put("message","删除公告信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> release(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                ReleaseDateAndId releaseDateAndId = new ReleaseDateAndId();
                //填入主键id
                releaseDateAndId.setId(id);
                //填入发布时间
                releaseDateAndId.setReleaseDate(new Date());
                //发布公告管理信息
                int update = sysAnnouncementManagementDao.release(releaseDateAndId);
                if (update <= 0){
                    throw new RuntimeException("发布失败");
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
        map.put("message","发布成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoPreviewAnnouncementManagement preview(Integer id) {
        VoPreviewAnnouncementManagement voPreviewAnnouncementManagement = sysAnnouncementManagementDao.preview(id);
        //查询照片信息
        UploadUtil uploadUtil = new UploadUtil();
        //传入照片信息
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", id, "announcementImg");
        voPreviewAnnouncementManagement.setImgUrls(imgByDate);
        return voPreviewAnnouncementManagement;
    }
}
