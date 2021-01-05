package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysActivityManagementDao;
import com.api.model.operationManagement.ActivityManagement;
import com.api.model.operationManagement.SearchActivityManagement;
import com.api.model.system.SysUser;
import com.api.manage.service.operationManagement.SysActivityManagementService;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoActivityManagement;
import com.api.vo.operationManagement.VoActivityRegistration;
import com.api.vo.operationManagement.VoFindByIdActivityManagement;
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
public class SysActivityManagementServiceImpl implements SysActivityManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysActivityManagementDao sysActivityManagementDao;

    @Override
    public List<VoActivityManagement> list(SearchActivityManagement searchActivityManagement) {
        //查询所有的活动信息
        List<VoActivityManagement> list = sysActivityManagementDao.list(searchActivityManagement);
        if (list != null && list.size()>0){
            for (VoActivityManagement voActivityManagement : list) {
                //填入报名人数
                int count = sysActivityManagementDao.countRegistrationByActivityId(voActivityManagement.getId());
                voActivityManagement.setRegistrationNumber(count);
            }
        }
        return list;
    }

    @Override
    public List<VoResourcesImg> findImgById(Integer id) {
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", id, "activityImg");
        return imgByDate;
    }

    @Override
    public List<VoActivityRegistration> findRegistrationById(Integer id) {
        return sysActivityManagementDao.findRegistrationById(id);
    }

    @Override
    public Map<String, Object> insert(ActivityManagement activityManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            activityManagement.setCreateId(sysUser.getId());
            //填入创建时间
            activityManagement.setCreateDate(new Date());
            //填入是否删除，初始为1.非删
            activityManagement.setIsDelete(1);
            //添加活动信息,并返回主键id
            int insert = sysActivityManagementDao.insert(activityManagement);
            if (insert <= 0){
                throw new RuntimeException("添加活动信息失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //上传图片到数据库
            uploadUtil.saveUrlToDB(activityManagement.getFileUrls(),"sysActivityManagement",activityManagement.getId(),"activityImg","600",30,20);
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
        map.put("message","添加活动信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoFindByIdActivityManagement findById(Integer id) {
        VoFindByIdActivityManagement byId = sysActivityManagementDao.findById(id);
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", id, "activityImg");
        byId.setImgUrls(imgByDate);
        return byId;
    }

    @Override
    @Transactional
    public Map<String, Object> update(ActivityManagement activityManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //先删除图片资源
            uploadUtil.delete("sysActivityManagement",activityManagement.getId(),"activityImg");
            //再添加图片资源到数据库
            uploadUtil.saveUrlToDB(activityManagement.getFileUrls(),"sysActivityManagement",activityManagement.getId(),"activityImg","600",30,20);

            //填入修改人
            activityManagement.setModifyId(sysUser.getId());
            //填入修改时间
            activityManagement.setModifyDate(new Date());
            //修改活动信息
            int update = sysActivityManagementDao.update(activityManagement);
            if (update <= 0){
                throw new RuntimeException("修改活动信息失败");
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
        map.put("message","修改活动信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据主键id假删除活动信息
                int update = sysActivityManagementDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除活动信息失败");
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
        map.put("message","删除活动信息成功");
        map.put("status",true);
        return map;
    }
}
