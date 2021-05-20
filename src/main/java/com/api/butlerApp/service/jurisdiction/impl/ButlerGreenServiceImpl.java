package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerGreenDao;
import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ButlerGreenServiceImpl implements ButlerGreenService {
    @Resource
    ButlerGreenDao butlerGreenDao;
}
