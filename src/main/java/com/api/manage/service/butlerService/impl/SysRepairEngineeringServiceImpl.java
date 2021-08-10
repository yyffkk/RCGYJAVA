package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysRepairEngineeringDao;
import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRepairEngineeringServiceImpl implements SysRepairEngineeringService {
    @Resource
    SysRepairEngineeringDao sysRepairEngineeringDao;

    @Override
    public List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering) {
        return sysRepairEngineeringDao.list(searchRepairEngineering);
    }
}
