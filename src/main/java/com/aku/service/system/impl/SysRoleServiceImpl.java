package com.aku.service.system.impl;

import com.aku.dao.system.SysRoleDao;
import com.aku.model.system.SysRole;
import com.aku.service.system.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色service实现
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysRoleDao sysRoleDao;

    /**
     * 角色ID查找角色信息
     * @param id 角色ID
     * @return 角色信息
     */
    @Override
    public SysRole findById(Integer id) {
        return sysRoleDao.findById(id);
    }
    /**
     * 根据组织ID查找角色信息
     * @param organizationId 组织ID
     * @return 角色信息
     */
    @Override
    public SysRole findByOrganizationId(Integer organizationId) {
        return sysRoleDao.findByOrganizationId(organizationId);
    }

    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    @Override
    public SysRole findByIdentityId(Integer positionId) {
        return sysRoleDao.findByIdentityId(positionId);
    }
}
