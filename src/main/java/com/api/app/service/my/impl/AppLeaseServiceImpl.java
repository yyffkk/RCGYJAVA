package com.api.app.service.my.impl;

import com.api.app.dao.my.AppLeaseDao;
import com.api.app.service.my.AppLeaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppLeaseServiceImpl implements AppLeaseService {
    @Resource
    AppLeaseDao appLeaseDao;
}
