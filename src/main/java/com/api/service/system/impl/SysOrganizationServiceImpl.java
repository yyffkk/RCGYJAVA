package com.api.service.system.impl;

import com.api.dao.system.SysOrganizationDao;
import com.api.model.system.SysOrganization;
import com.api.service.system.SysOrganizationService;
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