package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.LeaseContractDao;
import com.api.manage.service.butlerService.LeaseContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LeaseContractServiceImpl implements LeaseContractService {
    @Resource
    LeaseContractDao leaseContractDao;
}
