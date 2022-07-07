package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysHousekeepingDao;
import com.api.manage.service.butlerService.SysHousekeepingService;
import com.api.model.butlerService.SearchHousekeeping;
import com.api.vo.butlerService.VoHousekeeping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysHousekeepingServiceImpl implements SysHousekeepingService {
    @Resource
    SysHousekeepingDao sysHousekeepingDao;

    @Override
    public List<VoHousekeeping> list(SearchHousekeeping searchHousekeeping) {
        return sysHousekeepingDao.list(searchHousekeeping);
    }
}
