package com.api.app.service.butler.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.app.service.butler.DecorationApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DecorationApplicationServiceImpl implements DecorationApplicationService {
    @Resource
    DecorationApplicationDao decorationApplicationDao;
}
