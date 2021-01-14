package com.api.app.service.my.impl;

import com.api.app.dao.my.MyHouseDao;
import com.api.app.service.my.MyHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyHouseServiceImpl implements MyHouseService {
    @Resource
    MyHouseDao myHouseDao;
}
