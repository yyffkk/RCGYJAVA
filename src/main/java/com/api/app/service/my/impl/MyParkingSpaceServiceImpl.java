package com.api.app.service.my.impl;

import com.api.app.dao.my.MyParkingSpaceDao;
import com.api.app.service.my.MyParkingSpaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyParkingSpaceServiceImpl implements MyParkingSpaceService {
    @Resource
    MyParkingSpaceDao myParkingSpaceDao;

}
