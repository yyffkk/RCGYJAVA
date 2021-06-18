package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.LeaseDao;
import com.api.manage.service.butlerService.LeaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LeaseServiceImpl implements LeaseService {
    @Resource
    LeaseDao leaseDao;
}
