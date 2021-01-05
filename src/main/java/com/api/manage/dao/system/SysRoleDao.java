package com.api.manage.dao.system;

import com.api.model.system.SysRole;
import org.springframework.stereotype.Component;

/**
 * 角色Dao接口
 */
@Component
public interface SysRoleDao {
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
