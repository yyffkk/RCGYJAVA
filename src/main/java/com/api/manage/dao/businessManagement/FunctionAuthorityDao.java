package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.RoleIdAndJurisdictionId;
import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.model.businessManagement.RoleIdAndParentId;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoListJurisdiction;

import java.util.List;

public interface FunctionAuthorityDao {
    /**
     * 查询所属角色下所有的员工信息 （包含条件搜索）
     * @param searchFunctionAuthority 搜索条件
     * @return 员工信息集合
     */
    List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority);

    /**
     * 查询当前角色的所有权限信息
     * @param roleIdAndParentId 角色主键id 和 上级权限id
     * @return 当前角色的权限信息
     */
    List<VoListJurisdiction> listJurisdiction(RoleIdAndParentId roleIdAndParentId);

    /**
     * 删除该角色的所有权限
     * @param roleId 角色id
     * @return 影响行数
     */
    int deleteJurisdictionByRoleId(Integer roleId);

    /**
     * 为该角色添加权限
     * @param roleIdAndJurisdictionId 角色id 和 权限id
     * @return 影响行数
     */
    int insertJurisdiction(RoleIdAndJurisdictionId roleIdAndJurisdictionId);
}
