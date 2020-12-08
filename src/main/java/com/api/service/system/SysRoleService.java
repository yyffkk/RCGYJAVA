package com.api.service.system;

import com.api.model.system.SysRole;

/**
 * 角色service接口
 */
public interface SysRoleService {
    /**
     * 角色ID查找角色信息
     * @param id 角色ID
     * @return 角色信息
     */
    SysRole findById(Integer id);

    /**
     * 根据组织ID查找角色信息
     * @param organizationId 组织ID
     * @return 角色信息
     */
    SysRole findByOrganizationId(Integer organizationId);

    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    SysRole findByIdentityId(Integer positionId);
}
