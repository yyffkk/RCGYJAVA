package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.AuditManagementDao;
import com.api.manage.service.basicArchives.AuditManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuditManagementServiceImpl implements AuditManagementService {
    @Resource
    AuditManagementDao auditManagementDao;
}
