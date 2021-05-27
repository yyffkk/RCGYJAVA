package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppUserDecorationNewDao;
import com.api.app.service.butler.AppUserDecorationNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppUserDecorationNewServiceImpl implements AppUserDecorationNewService {
    @Resource
    AppUserDecorationNewDao appUserDecorationNewDao;
}
