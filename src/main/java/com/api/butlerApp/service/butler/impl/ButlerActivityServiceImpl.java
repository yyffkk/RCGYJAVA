package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerActivityDao;
import com.api.butlerApp.service.butler.ButlerActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ButlerActivityServiceImpl implements ButlerActivityService {
    @Resource
    ButlerActivityDao butlerActivityDao;
}
