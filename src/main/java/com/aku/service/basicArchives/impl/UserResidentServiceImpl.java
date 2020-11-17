package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.aku.dao.basicArchives.CpmParkingSpaceDao;
import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.CpmParkingSpace;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.system.SysUser;
import com.aku.service.basicArchives.CpmParkingSpaceService;
import com.aku.service.basicArchives.UserResidentService;
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
        UserResident userResident = userResidentDao.findById(id);
//        CpmBuildingUnitEstate cpmBuildingUnitEstate = cpmBuildingUnitEstateDao.findById(userResident.getBuildingUnitEstateId());
        List<CpmParkingSpace> cpmParkingSpaceList = cpmParkingSpaceDao.findByResidentId(id);


//        map.put("userResident",userResident);
//        map.put("cpmBuildingUnitEstate",cpmBuildingUnitEstate);
//        if (cpmParkingSpace != null){
//            map.put("cpmParkingSpaceId",cpmParkingSpace.getId());
//        }
        return map;
    }
}
