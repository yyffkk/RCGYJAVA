package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerHousekeepingDao;
import com.api.butlerApp.service.butler.ButlerHousekeepingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ButlerHousekeepingServiceImpl implements ButlerHousekeepingService {
    @Resource
    ButlerHousekeepingDao butlerHousekeepingDao;
}
