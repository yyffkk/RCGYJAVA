package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.CpmBuildingDao;
import com.api.model.basicArchives.CpmBuilding;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.vo.basicArchives.VoFindAll;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CpmBuildingServiceImpl implements CpmBuildingService {
    private final Map<String,Object> map = new HashMap<>();

    @Resource
    CpmBuildingDao cpmBuildingDao;

    @Override
    @RequiresPermissions(value = {"0201"})
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
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        try {
            for (int id : ids) {
                int delete = cpmBuildingDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除楼栋信息失败");
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
        map.put("message","批量删除楼栋信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoFindAll> findAll() {
        return cpmBuildingDao.findAll();
    }


}
