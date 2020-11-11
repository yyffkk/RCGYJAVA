package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.CpmBuildingDao;
import com.aku.model.basicArchives.CpmBuilding;
import com.aku.service.basicArchives.CpmBuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CpmBuildingServiceImpl implements CpmBuildingService {
    @Resource
    CpmBuildingDao cpmBuildingDao;

    @Override
    public List<CpmBuilding> list(CpmBuilding cpmBuilding) {
        return cpmBuildingDao.list(cpmBuilding);
    }
}
