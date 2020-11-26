package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingDao;
import com.aku.model.basicArchives.CpmBuilding;
import com.aku.model.system.SysUser;
import com.aku.service.basicArchives.CpmBuildingService;
import com.aku.vo.basicArchives.VoFindAll;
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

        //校验重复
        //根据楼栋编号查询是否已有楼栋信息
        CpmBuilding byNo = cpmBuildingDao.findByNo(cpmBuilding.getNo());
        if (byNo != null){
            map.put("message","楼栋编号已存在");
            map.put("status",false);
            return map;
        }
        //根据楼栋名称查询是否已有楼栋信息
        CpmBuilding byName = cpmBuildingDao.findByName(cpmBuilding.getName());
        if (byName != null){
            map.put("message","楼栋名称已存在");
            map.put("status",false);
            return map;
        }

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

        //校验重复
        //根据楼栋编号查询是否已有楼栋信息
        CpmBuilding byNo = cpmBuildingDao.findByNo(cpmBuilding.getNo());
        if (byNo != null){
            //如果输入id与查询到的id不一致，则修改了楼栋编号信息，并且楼栋编号重复
            if (!byNo.getId().equals(cpmBuilding.getId())){
                map.put("message","楼栋编号已存在");
                map.put("status",false);
                return map;
            }
        }
        //根据楼栋名称查询是否已有楼栋信息
        CpmBuilding byName = cpmBuildingDao.findByName(cpmBuilding.getName());
        if (byName != null){
            //如果输入id与查询到的id不一致，则修改了楼栋名称信息，并且楼栋名称重复
            if (!byName.getId().equals(cpmBuilding.getId())){
                map.put("message","楼栋名称已存在");
                map.put("status",false);
                return map;
            }
        }

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
    public Map<String, Object> delete(int[] ids) {
        boolean flag = true;
        for (int id : ids) {
            int delete = cpmBuildingDao.delete(id);
            if (delete<=0){
                flag = false;
            }
        }
        if (flag){
            map.put("message","删除楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoFindAll> findAll() {
        return cpmBuildingDao.findAll();
    }


}
