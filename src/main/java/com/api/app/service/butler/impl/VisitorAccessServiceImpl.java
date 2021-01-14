package com.api.app.service.butler.impl;

import com.api.app.dao.butler.VisitorAccessDao;
import com.api.app.service.butler.VisitorAccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitorAccessServiceImpl implements VisitorAccessService {
    @Resource
    VisitorAccessDao visitorAccessDao;

}
