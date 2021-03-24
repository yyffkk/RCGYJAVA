package com.api.app.service.my.impl;

import com.api.app.dao.my.MyCarDao;
import com.api.app.service.my.MyCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyCarServiceImpl implements MyCarService {
    @Resource
    MyCarDao myCarDao;
}
