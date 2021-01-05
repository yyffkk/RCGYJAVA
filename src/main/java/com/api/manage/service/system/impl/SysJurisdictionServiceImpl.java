package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysJurisdictionDao;
import com.api.model.system.SysJurisdiction;
import com.api.manage.service.system.SysJurisdictionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限Service实现
 */
@Service
public class SysJurisdictionServiceImpl implements SysJurisdictionService {

    @Resource
    SysJurisdictionDao sysJurisdictionDao;
    /**
     * 根据角色ID查找权限信息
     * @param roleId 角色ID
     * @return 权限信息
     */
    @Override
    public List<SysJurisdiction> findByRoleId(Integer roleId) {
        return sysJurisdictionDao.findByRoleId(roleId);
    }
}
