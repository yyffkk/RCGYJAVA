package com.api.common.dao;

import java.util.List;

public interface GetSysUserIdsDao {
    /**
     * 根据权限主键id查询角色主键id集合
     * @param jurisdictionId 权限主键id
     * @return 角色主键id集合
     */
    List<Integer> findRoleIdsByJurisdictionId(Integer jurisdictionId);

    /**
     * 根据角色主键id查询用户主键id集合（通过角色关联来查询用户）
     * @param roleId 角色主键id
     * @return 用户主键id集合
     */
    List<Integer> findUserIdsByRoleId(Integer roleId);

    /**
     * 根据权限主键id查询用户主键id集合(通过身份关联来查询用户)
     * @param jurisdictionId 权限主键id
     * @return 用户主键id集合
     */
    List<Integer> findUserIdsByJurisdictionId(Integer jurisdictionId);
}
