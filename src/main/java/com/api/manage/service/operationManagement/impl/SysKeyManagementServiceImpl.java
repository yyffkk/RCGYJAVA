package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysKeyManagementDao;
import com.api.manage.service.operationManagement.SysKeyManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysKeyManagementServiceImpl implements SysKeyManagementService {
    @Resource
    SysKeyManagementDao sysKeyManagementDao;
}
