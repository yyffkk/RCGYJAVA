package com.api.service.operationManagement.impl;

import com.api.dao.operationManagement.SysActivityManagementDao;
import com.api.service.operationManagement.SysActivityManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysActivityManagementServiceImpl implements SysActivityManagementService {
    @Resource
    SysActivityManagementDao sysActivityManagementDao;
}
