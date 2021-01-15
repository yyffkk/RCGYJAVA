package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppConvenientTelephoneDao;
import com.api.app.service.butler.AppConvenientTelephoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppConvenientTelephoneServiceImpl implements AppConvenientTelephoneService {
    @Resource
    AppConvenientTelephoneDao appConvenientTelephoneDao;


}
