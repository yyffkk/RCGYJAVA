package com.api.butlerApp.service.personalData.impl;

import com.api.butlerApp.dao.personalData.ButlerPersonalDataDao;
import com.api.butlerApp.service.personalData.ButlerPersonalDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ButlerPersonalDataServiceImpl implements ButlerPersonalDataService {
    @Resource
    ButlerPersonalDataDao butlerPersonalDataDao;
}
