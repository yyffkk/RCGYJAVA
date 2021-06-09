package com.api.manage.service.dataStatistics.impl;

import com.api.manage.dao.dataStatistics.DataStatisticsDao;
import com.api.manage.service.dataStatistics.DataStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Resource
    DataStatisticsDao dataStatisticsDao;
}
