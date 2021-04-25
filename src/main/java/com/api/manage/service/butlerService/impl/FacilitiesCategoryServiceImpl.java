package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.FacilitiesCategoryDao;
import com.api.manage.service.butlerService.FacilitiesCategoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategoryDetail;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacilitiesCategoryServiceImpl implements FacilitiesCategoryService {
    private static Map<String,Object> map = null;

    @Resource
    FacilitiesCategoryDao facilitiesCategoryDao;

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
}
