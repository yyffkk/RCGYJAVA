package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesCategoryDao;
import com.api.manage.service.butlerService.SysFacilitiesCategoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategoryDetail;
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
    public Map<String, Object> insert(FacilitiesCategory facilitiesCategory) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        facilitiesCategory.setNum(0); //添加默认设施数量 0
        facilitiesCategory.setCreateId(sysUser.getId());
        facilitiesCategory.setCreateDate(new Date());
        facilitiesCategory.setIsDelete(1); //添加默认 1.非删

        int insert = facilitiesCategoryDao.insert(facilitiesCategory);
        if (insert <=0){
            map.put("message","添加失败");
            map.put("status",false);
        }else {
            map.put("message","添加成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> findDetailById(Integer id) {
        map = new HashMap<>();
        VoFacilitiesCategoryDetail facilitiesCategoryDetail = facilitiesCategoryDao.findDetailById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",facilitiesCategoryDetail);
        return map;
    }

    @Override
    public Map<String, Object> update(FacilitiesCategory facilitiesCategory) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        facilitiesCategory.setModifyId(sysUser.getId());
        facilitiesCategory.setModifyDate(new Date());
        int update = facilitiesCategoryDao.update(facilitiesCategory);
        if (update <=0){
            map.put("message","修改失败");
            map.put("status",false);
        }else {
            map.put("message","修改成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
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
