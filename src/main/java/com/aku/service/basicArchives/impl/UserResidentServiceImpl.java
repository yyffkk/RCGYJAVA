package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.UserResidentDao;
import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.service.basicArchives.UserResidentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserResidentServiceImpl implements UserResidentService {
    @Resource
    UserResidentDao userResidentDao;

    @Override
    public List<UserResident> list(UserResident userResident) {
        return userResidentDao.list(userResident);
    }

    @Transactional
    @Override
    public Map<String, Object> insert(UserResident userResident, CpmBuildingUnitEstate cpmBuildingUnitEstate) {
        //添加楼宇单元房产信息


        //添加业主信息
        int insert = userResidentDao.insert(userResident);

        return null;
    }
}
