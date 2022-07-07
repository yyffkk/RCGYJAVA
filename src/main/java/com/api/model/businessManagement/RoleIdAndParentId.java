package com.api.model.businessManagement;

/**
 * 角色主键id 和 上级权限id
 */
public class RoleIdAndParentId {
    /**
     * 角色主键id
     */
    private Integer roleId;
    /**
     * 上级权限id，最上级为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "RoleIdAndParentId{" +
                "roleId=" + roleId +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public RoleIdAndParentId() {
    }

    public RoleIdAndParentId(Integer roleId, Integer parentId) {
        this.roleId = roleId;
        this.parentId = parentId;
    }
}
