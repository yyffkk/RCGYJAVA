package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppGambitDao;
import com.api.app.service.butler.AppGambitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppGambitServiceImpl implements AppGambitService {
    @Resource
    AppGambitDao appGambitDao;
}
