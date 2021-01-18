package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppReportRepairDao;
import com.api.app.service.butler.AppReportRepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppReportRepairServiceImpl implements AppReportRepairService {
    @Resource
    AppReportRepairDao appReportRepairDao;
}
