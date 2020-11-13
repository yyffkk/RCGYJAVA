package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.system.SysUser;
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

    @Override
    public List<UserResident> list(UserResident userResident) {
        return userResidentDao.list(userResident);
    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident, CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        cpmBuildingUnitEstate.setCreateId(sysUser.getId());
        cpmBuildingUnitEstate.setCreateDate(new Date());
        cpmBuildingUnitEstate.setIsDelete(1);

        //添加楼宇单元房产信息
        int insert1 = cpmBuildingUnitEstateDao.insert(cpmBuildingUnitEstate);
        if (insert1>0){
            userResident.setBuildingUnitEstateId(cpmBuildingUnitEstate.getId());
            userResident.setCreateId(sysUser.getId());
            userResident.setCreateDate(new Date());
            userResident.setType(RESIDENT_TYPE);
            //添加业主信息
            int insert = userResidentDao.insert(userResident);
            if (insert >0 ){
                map.put("message","添加楼栋单元房产信息成功,已关联添加成功业主信息");
                map.put("status",true);
            }else {
                throw new RuntimeException("添加业主信息失败");
            }
        }else {
            map.put("message","添加楼栋单元房产信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId) {
        return userResidentDao.findByBuildingUnitEstateId(buildingUnitEstateId);
    }
}
