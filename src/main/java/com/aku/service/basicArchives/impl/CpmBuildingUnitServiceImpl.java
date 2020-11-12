package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitDao;
import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.model.system.SysUser;
import com.aku.model.vo.VoCpmBuildingUnit;
import com.aku.service.basicArchives.CpmBuildingUnitService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CpmBuildingUnitServiceImpl implements CpmBuildingUnitService {
    private final Map<String,Object> map = new HashMap<>();

    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit) {
        return cpmBuildingUnitDao.list(voCpmBuildingUnit);
    }

    @Override
    public Map<String, Object> insert(CpmBuildingUnit cpmBuildingUnit) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        cpmBuildingUnit.setCreateId(sysUser.getId());
        cpmBuildingUnit.setCreateDate(new Date());
        int insert = cpmBuildingUnitDao.insert(cpmBuildingUnit);
        if (insert>0){
            map.put("message","添加楼栋单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋单元信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public CpmBuildingUnit findById(Integer id) {
        return cpmBuildingUnitDao.findById(id);
    }

    @Override
    public Map<String, Object> update(CpmBuildingUnit cpmBuildingUnit) {
        int update = cpmBuildingUnitDao.update(cpmBuildingUnit);
        if (update>0){
            map.put("message","修改楼栋单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改楼栋单元信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        int delete = cpmBuildingUnitDao.delete(id);
        if (delete>0){
            map.put("message","删除楼栋单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋单元信息失败");
            map.put("status",false);
        }
        return map;
    }
}
