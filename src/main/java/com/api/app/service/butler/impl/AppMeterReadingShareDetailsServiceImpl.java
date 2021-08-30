package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppMeterReadingShareDetailsDao;
import com.api.app.service.butler.AppMeterReadingShareDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppMeterReadingShareDetailsServiceImpl implements AppMeterReadingShareDetailsService {
    @Resource
    AppMeterReadingShareDetailsDao appMeterReadingShareDetailsDao;
}
