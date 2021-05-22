package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysContractDao;
import com.api.manage.service.businessManagement.SysContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysContractServiceImpl implements SysContractService {
    @Resource
    SysContractDao sysContractDao;
}
