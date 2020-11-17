package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.*;
import com.aku.model.basicArchives.*;
import com.aku.model.system.SysUser;
import com.aku.service.basicArchives.UserResidentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserResidentServiceImpl implements UserResidentService {
    private final Map<String,Object> map = new HashMap<>();
    //设置业主类型，1业主
    private static final int RESIDENT_TYPE = 1;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    CpmParkingSpaceDao cpmParkingSpaceDao;
    @Resource
    CpmBuildingDao cpmBuildingDao;
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;

    @Override
    public List<UserResident> list(UserResident userResident) {
        return userResidentDao.list(userResident);
    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident,Integer cpmParkingSpaceId) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        userResident.setCreateId(sysUser.getId());
        userResident.setCreateDate(new Date());
        userResident.setType(RESIDENT_TYPE);
        //添加业主信息(及其关联楼栋单元房产)
        int insert = userResidentDao.insert(userResident);
        if (insert >0 ){
            //添加车位信息
            if (cpmParkingSpaceId != null){
                CpmParkingSpace cpmParkingSpace = new CpmParkingSpace();
                cpmParkingSpace.setId(cpmParkingSpaceId);
                cpmParkingSpace.setResidentId(userResident.getId());
                cpmParkingSpace.setModifyId(sysUser.getId());
                cpmParkingSpace.setModifyDate(new Date());
                int update = cpmParkingSpaceDao.update(cpmParkingSpace);
                if (update>0){
                    map.put("message","添加业主信息成功，已关联楼栋单元房产信息,及其成功关联车位");
                    map.put("status",true);
                }else {
                    throw new RuntimeException("关联车位信息失败");
                }
            }else {
                map.put("message","添加业主信息成功，已关联楼栋单元房产信息");
                map.put("status",true);
            }
        }else {
            map.put("message","添加业主信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId) {
        return userResidentDao.findByBuildingUnitEstateId(buildingUnitEstateId);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        //根据id查询住户信息
        UserResident userResident = userResidentDao.findById(id);
        //查询住户所拥有的房产
        List<CpmBuildingUnitEstate> cpmBuildingUnitEstateList = cpmBuildingUnitEstateDao.findByResidentId(id);
        cpmBuildingUnitEstateDao.findById(id);
        ArrayList<Object> objects = new ArrayList<>();
        //遍历查询出房产对应的单元和楼栋
        for (CpmBuildingUnitEstate cpmBuildingUnitEstate : cpmBuildingUnitEstateList) {
            //根据房产主键id查询对应的单元号
            CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(cpmBuildingUnitEstate.getBuildingUnitId());
            //根据单元主键id查询对应的楼栋号
            CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
            //楼栋，单元，房产（房间）
            objects.add(cpmBuilding.getId()+","+cpmBuildingUnit.getId()+","+cpmBuildingUnitEstate.getId());
        }
        //查询业主所有的车位，判断是否有车位
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByResidentId(id);
        ArrayList<Object> objects1 = new ArrayList<>();
        //遍历查询所有的车位id
        for (CpmParkingSpace cpmParkingSpace : cpmParkingSpaceList) {
            objects1.add(cpmParkingSpace.getId());
        }

        map.put("cpmParkingSpaceIdList",objects1);
        map.put("userResident",userResident);
        map.put("cpmBuildingUnitEstateIdList",objects);
        return map;
    }
}
