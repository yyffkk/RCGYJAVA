package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysHouseTypeDescriptionDao;
import com.api.manage.service.operationManagement.SysHouseTypeDescriptionService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchHouseTypeDescription;
import com.api.model.operationManagement.SysHouseTypeDescription;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.SysHouseTypeDescriptionFBIVo;
import com.api.vo.operationManagement.SysHouseTypeDescriptionListVo;
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
public class SysHouseTypeDescriptionServiceImpl implements SysHouseTypeDescriptionService {
    private static Map<String,Object> map = null;
    @Resource
    SysHouseTypeDescriptionDao sysHouseTypeDescriptionDao;

    @Override
    public List<SysHouseTypeDescriptionListVo> list(SearchHouseTypeDescription searchHouseTypeDescription) {
        return sysHouseTypeDescriptionDao.list(searchHouseTypeDescription);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        SysHouseTypeDescriptionFBIVo sysHouseTypeDescriptionFBIVo = sysHouseTypeDescriptionDao.findById(id);
        if (sysHouseTypeDescriptionFBIVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysHouseTypeDescription", sysHouseTypeDescriptionFBIVo.getId(), "HouseTypeImg");
            sysHouseTypeDescriptionFBIVo.setImgUrls(imgByDate);
        }

        map.put("message","请求成功");
        map.put("data",sysHouseTypeDescriptionFBIVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysHouseTypeDescription sysHouseTypeDescription) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysHouseTypeDescription.setCreateId(sysUser.getId());
        sysHouseTypeDescription.setCreateDate(new Date());
        if (sysHouseTypeDescription.getStatus() == 2){//如果2.已发布，则填入发布时间
            sysHouseTypeDescription.setReleaseDate(new Date());
        }

        try {
            int insert = sysHouseTypeDescriptionDao.insert(sysHouseTypeDescription);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysHouseTypeDescription.getFileUrls(),"sysHouseTypeDescription", sysHouseTypeDescription.getId(), "HouseTypeImg","600",30,20);
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
    @Transactional
    public Map<String, Object> update(SysHouseTypeDescription sysHouseTypeDescription) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysHouseTypeDescription.setModifyId(sysUser.getId());
        sysHouseTypeDescription.setModifyDate(new Date());
        if (sysHouseTypeDescription.getStatus() == 2){//如果2.已发布，则填入发布时间
            sysHouseTypeDescription.setReleaseDate(new Date());
        }

        try {
            int update = sysHouseTypeDescriptionDao.update(sysHouseTypeDescription);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片信息
            uploadUtil.delete("sysHouseTypeDescription", sysHouseTypeDescription.getId(), "HouseTypeImg");
            //再添加照片信息
            uploadUtil.saveUrlToDB(sysHouseTypeDescription.getFileUrls(),"sysHouseTypeDescription", sysHouseTypeDescription.getId(), "HouseTypeImg","600",30,20);
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

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try{
            UploadUtil uploadUtil = new UploadUtil();
            for (int id : ids) {
                int delete = sysHouseTypeDescriptionDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
                }
                uploadUtil.delete("sysHouseTypeDescription", id, "HouseTypeImg");
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
    public Map<String, Object> release(Integer id) {
        map = new HashMap<>();
        SysHouseTypeDescription sysHouseTypeDescription = new SysHouseTypeDescription();
        sysHouseTypeDescription.setId(id);
        sysHouseTypeDescription.setReleaseDate(new Date());
        sysHouseTypeDescription.setStatus(2);//2.已发布

        int release = sysHouseTypeDescriptionDao.release(sysHouseTypeDescription);
        if (release > 0){
            map.put("message","发布成功");
            map.put("status",true);
        }else {
            map.put("message","发布失败");
            map.put("status",false);
        }
        return map;
    }
}
