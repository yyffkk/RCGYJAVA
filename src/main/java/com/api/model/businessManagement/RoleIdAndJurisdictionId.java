package com.api.model.businessManagement;
/**
 * 角色id 和 权限id
 */
public class RoleIdAndJurisdictionId {
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer jurisdictionId;

    @Override
    public String toString() {
        return "RoleIdAndJurisdictionId{" +
                "roleId=" + roleId +
                ", jurisdictionId=" + jurisdictionId +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    public void setJurisdictionId(Integer jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
    }

    public RoleIdAndJurisdictionId() {
    }

    public RoleIdAndJurisdictionId(Integer roleId, Integer jurisdictionId) {
        this.roleId = roleId;
        this.jurisdictionId = jurisdictionId;
    }
}
