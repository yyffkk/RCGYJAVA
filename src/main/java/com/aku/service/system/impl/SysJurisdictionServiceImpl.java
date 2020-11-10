package com.aku.service.system.impl;

import com.aku.dao.system.SysJurisdictionDao;
import com.aku.model.system.SysJurisdiction;
import com.aku.service.system.SysJurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限Service实现
 */
@Service
public class SysJurisdictionServiceImpl implements SysJurisdictionService {

    @Autowired
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
