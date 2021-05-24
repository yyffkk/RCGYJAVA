package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.UserVisitorsNewDao;
import com.api.manage.service.butlerService.UserVisitorsNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserVisitorsNewServiceImpl implements UserVisitorsNewService {
    @Resource
    UserVisitorsNewDao userVisitorsNewDao;
}
