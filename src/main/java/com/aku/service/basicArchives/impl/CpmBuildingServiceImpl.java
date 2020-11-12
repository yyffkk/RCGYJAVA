package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingDao;
import com.aku.model.basicArchives.CpmBuilding;
import com.aku.model.system.SysUser;
import com.aku.service.basicArchives.CpmBuildingService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CpmBuildingServiceImpl implements CpmBuildingService {
    private final Map<String,Object> map = new HashMap<>();

    @Resource
    CpmBuildingDao cpmBuildingDao;

    @Override
    public List<CpmBuilding> list(CpmBuilding cpmBuilding) {
        return cpmBuildingDao.list(cpmBuilding);
    }

    @Override
    public Map<String, Object> insert(CpmBuilding cpmBuilding) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        cpmBuilding.setCreateId(sysUser.getId());
        cpmBuilding.setCreateDate(new Date());
        cpmBuilding.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16));
        int insert = cpmBuildingDao.insert(cpmBuilding);
        if (insert>0){
            map.put("message","添加楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public CpmBuilding findById(Integer id) {
        return cpmBuildingDao.findById(id);
    }

    @Override
    public Map<String, Object> update(CpmBuilding cpmBuilding) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        cpmBuilding.setModifyId(sysUser.getId());
        cpmBuilding.setModifyDate(new Date());
        int update = cpmBuildingDao.update(cpmBuilding);
        if (update>0){
            map.put("message","修改楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        int delete = cpmBuildingDao.delete(id);
        if (delete>0){
            map.put("message","删除楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }


}
