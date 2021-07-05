package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysMaterialInventoryDao;
import com.api.manage.service.operationManagement.SysMaterialInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysMaterialInventoryServiceImpl implements SysMaterialInventoryService {
    @Resource
    SysMaterialInventoryDao sysMaterialInventoryDao;
}
