package com.api.manage.service.system;

import com.api.model.system.SysRole;
import com.api.vo.system.VoCheckRole;
import com.api.vo.system.VoRole;

import java.util.List;
import java.util.Map;

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
    List<SysRole> findByOrganizationId(Integer organizationId);

    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    List<SysRole> findByIdentityId(Integer positionId);

    /**
     * 查询全部用户角色信息
     * @return 用户角色信息
     */
    List<VoRole> roleList();

    /**
     * 添加角色信息
     * @param sysRole 角色表
     * @return map
     */
    Map<String, Object> insertRole(SysRole sysRole);

    /**
     * 修改角色信息
     * @param sysRole 角色表
     * @return map
     */
    Map<String, Object> updateRole(SysRole sysRole);

    /**
     * 删除角色信息
     * @param sysRole 角色表
     * @return map
     */
    Map<String, Object> deleteRole(SysRole sysRole);
}
