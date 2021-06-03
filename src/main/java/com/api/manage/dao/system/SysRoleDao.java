package com.api.manage.dao.system;

import com.api.model.businessManagement.UserIdAndParentId;
import com.api.model.system.SysRole;
import com.api.vo.system.VoCheckRole;
import com.api.vo.system.VoRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色Dao接口
 */
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
    List<SysRole> findByOrganizationId(Integer organizationId);
    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    List<SysRole> findByIdentityId(Integer positionId);

    /**
     * 查询全部用户角色信息
     * @return 用户角色信息集合
     */
    List<VoRole> roleList(Integer parentId);

    /**
     * 根据角色主键id查询角色名称
     * @param s 角色主键id
     * @return 角色名称
     */
    String findNameByRoleId(Integer s);

    /**
     * 添加角色信息
     * @param sysRole 角色表
     * @return 影响行数
     */
    int insertRole(SysRole sysRole);

    /**
     * 修改角色信息
     * @param sysRole 角色表
     * @return 影响行数
     */
    int updateRole(SysRole sysRole);

    /**
     * 判断是否有员工所属
     * @param roleId 角色主键id
     * @return 绑定员工数量
     */
    int countUserByRoleId(Integer roleId);

    /**
     * 删除角色信息
     * @param roleId 角色主键id
     * @return 影响行数
     */
    int deleteRole(Integer roleId);

    /**
     * 根据角色主键id删除角色权限关联表信息
     * @param roleId 角色主键id
     */
    int deleteRoleJurisdictionByRoleId(Integer roleId);
}
