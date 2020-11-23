package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.*;
import com.aku.model.system.SysUser;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.service.basicArchives.CpmBuildingUnitEstateService;
import com.aku.vo.basicArchives.VoFindAll;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CpmBuildingUnitEstateServiceImpl implements CpmBuildingUnitEstateService {
    private final Map<String,Object> map = new HashMap<>();
    //设置业主类型，1业主
    private static final int RESIDENT_TYPE = 1;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    UserResidentDao userResidentDao;

    @Override
    public List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate) {
        return cpmBuildingUnitEstateDao.list(voCpmBuildingUnitEstate);
    }

    @Override
    public Map<String, Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        int insert = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert>0){
            map.put("message","添加楼栋单元房产信息成功，非关联业主");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋单元房产信息失败，非关联业主");
            map.put("status",false);
        }
        return map;

    }

    @Transactional
    @Override
    public Map<String, Object> insert(List<UserResident> userResidentList, CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        //添加楼宇单元房产信息
        int insert1 = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert1>0){
            for (UserResident userResident : userResidentList) {
                userResident.setCreateId(sysUser.getId());
                userResident.setCreateDate(new Date());
                userResident.setType(RESIDENT_TYPE);
                //添加业主信息
                int insert = userResidentDao.insert(userResident);
                if (insert >0 ){
                    //添加业主房产关联数据
                    CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                    cpmResidentEstate.setResidentId(userResident.getId());
                    cpmResidentEstate.setBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
                    int insert2 = userResidentDao.insertResidentEstate(cpmResidentEstate);
                    if (insert2>0){
                        map.put("message","添加楼栋单元房产信息成功,已关联添加成功业主信息");
                        map.put("status",true);
                    }else {
                        throw new RuntimeException("添加业主房产关联表失败");
                    }
                }else {
                    throw new RuntimeException("添加业主信息失败");
                }
            }
        }else {
            map.put("message","添加楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public CpmBuildingUnitEstate findById(Integer id) {
        return cpmBuildingUnitEstateDao.findById(id);
    }

    @Override
    public Map<String, Object> delete(Integer id) {

        //查询是否有关联业主信息
        List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(id);
        if (byBuildingUnitEstateId != null && byBuildingUnitEstateId.size()>0){
            map.put("message","删除失败，请先解除关联业主信息");
            map.put("status",false);
            return map;
        }
        //假删除房产信息
        int delete = cpmBuildingUnitEstateDao.delete(id);
        if (delete >0){
            map.put("message","删除楼栋单元房产信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoFindAll> findAll() {
        return cpmBuildingUnitEstateDao.findAll();
    }

    @Override
    @Transactional
    public Map<String, Object> update(EstateAndResidentList estateAndResident) {
        boolean flag =true;
        //修改房屋信息
        int update = cpmBuildingUnitEstateDao.update(estateAndResident.getEstate());
        if (update <= 0){
            flag = false;
        }

        //---修改关联业主信息---
        //根据楼栋单元房产Id查询楼栋单元房产信息
        List<UserResident> byBuildingUnitEstateId = userResidentDao.findByBuildingUnitEstateId(estateAndResident.getEstate().getId());
        if (byBuildingUnitEstateId != null){
            for (UserResident userResident : byBuildingUnitEstateId) {
                //先删除所有该房产的业主关联信息
                int delete = userResidentDao.deleteByResidentIdAndEstateId(new ResidentIdAndEstateId(userResident.getId(), estateAndResident.getEstate().getId()));
                if (delete<=0){
                    flag = false;
                }
            }
        }
//        再添加业主关联信息
        if (estateAndResident.getResidentList()!=null){
            for (UserResident userResident : estateAndResident.getResidentList()) {
                CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                cpmResidentEstate.setBuildingUnitEstateId(estateAndResident.getEstate().getId());
                cpmResidentEstate.setResidentId(userResident.getId());
                int i = userResidentDao.insertResidentEstate(cpmResidentEstate);
                if (i<=0){
                    flag = false;
                }
            }
        }
        if (flag){
            map.put("message","修改房产信息成功");
            map.put("status",true);
        }else {
            throw new RuntimeException("修改房产信息失败");
        }
        return map;
    }

    @Override
    public List<VoFindAll> findByBuildingUnitId(Integer id) {
        return cpmBuildingUnitEstateDao.findByBuildingUnitId(id);
    }
}
