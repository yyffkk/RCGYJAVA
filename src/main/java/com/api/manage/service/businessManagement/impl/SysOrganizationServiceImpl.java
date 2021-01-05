package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysOrganizationDao;
import com.api.model.businessManagement.SysOrganization;
import com.api.manage.service.businessManagement.SysOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 组织service实现
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {
    @Resource
    SysOrganizationDao sysOrganizationDao;

    @Override
    public SysOrganization findById(SysOrganization sysOrganization) {
        return sysOrganizationDao.findById(sysOrganization.getId());
    }
}
