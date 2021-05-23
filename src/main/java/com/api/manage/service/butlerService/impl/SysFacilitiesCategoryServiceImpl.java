package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesCategoryDao;
import com.api.manage.service.butlerService.SysFacilitiesCategoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategoryDetail;
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
public class SysFacilitiesCategoryServiceImpl implements SysFacilitiesCategoryService {
    private static Map<String,Object> map = null;

    @Resource
    SysFacilitiesCategoryDao facilitiesCategoryDao;

    @Override
    public List<VoFacilitiesCategory> list(SearchFacilitiesCategory facilitiesCategory) {
        return facilitiesCategoryDao.list(facilitiesCategory);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(FacilitiesCategory facilitiesCategory) {
        map = new HashMap<>();
        try {
            if (facilitiesCategory.getType() != 1 && facilitiesCategory.getType() != 2){
                //分类类型：1.设施，2.设备
                throw new RuntimeException("设施分类类型填写有误");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            facilitiesCategory.setNum(0); //添加默认设施数量 0
            facilitiesCategory.setCreateId(sysUser.getId());
            facilitiesCategory.setCreateDate(new Date());
            facilitiesCategory.setIsDelete(1); //添加默认 1.非删

            //添加设施分类信息
            int insert = facilitiesCategoryDao.insert(facilitiesCategory);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }

            //上传照片路径到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(facilitiesCategory.getImgUrls(),"sysFacilitiesCategory",facilitiesCategory.getId(),"categoryImg","600",30,20);
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
    public Map<String, Object> findDetailById(Integer id) {
        map = new HashMap<>();
        VoFacilitiesCategoryDetail facilitiesCategoryDetail = facilitiesCategoryDao.findDetailById(id);
        if (facilitiesCategoryDetail != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysFacilitiesCategory", id, "categoryImg");
            facilitiesCategoryDetail.setFiles(imgByDate);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",facilitiesCategoryDetail);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(FacilitiesCategory facilitiesCategory) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            facilitiesCategory.setModifyId(sysUser.getId());
            facilitiesCategory.setModifyDate(new Date());
            int update = facilitiesCategoryDao.update(facilitiesCategory);
            if (update <=0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片信息
            uploadUtil.delete("sysFacilitiesCategory", facilitiesCategory.getId(), "categoryImg");
            //再添加照片信息
            uploadUtil.saveUrlToDB(facilitiesCategory.getImgUrls(),"sysFacilitiesCategory",facilitiesCategory.getId(),"categoryImg","600",30,20);

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
            for (int id : ids) {
                //根据设施/设备分类主键id 查询未删除设施/设备数量
                int count = facilitiesCategoryDao.countFacilitiesByCategoryId(id);
                if (count >0){
                    throw new RuntimeException("所选分类下存在设施信息，不可删除");
                }

                int update = facilitiesCategoryDao.delete(id);
                if (update <= 0){
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
}
