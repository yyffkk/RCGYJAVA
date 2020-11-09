package com.aku.service.system.impl;

import com.aku.dao.system.SysOrganizationDao;
import com.aku.model.system.SysOrganization;
import com.aku.service.system.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 组织service实现
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {
    @Autowired
    SysOrganizationDao sysOrganizationDao;

    @Override
    public SysOrganization findById(SysOrganization sysOrganization) {
        return sysOrganizationDao.findById(sysOrganization.getId());
    }
}
