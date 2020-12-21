package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysReportRepairDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysReportRepairServiceImpl {
    @Resource
    SysReportRepairDao sysReportRepairDao;
}
