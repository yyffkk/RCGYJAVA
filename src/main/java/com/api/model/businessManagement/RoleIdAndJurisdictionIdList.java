package com.api.model.businessManagement;

import java.util.Arrays;

/**
 * 角色id 和 权限id数组
 */
public class RoleIdAndJurisdictionIdList {
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id数组
     */
    private Integer[] jurisdictionIdList;

    @Override
    public String toString() {
        return "RoleIdAndJurisdictionIdList{" +
                "roleId=" + roleId +
                ", jurisdictionIdList=" + Arrays.toString(jurisdictionIdList) +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer[] getJurisdictionIdList() {
        return jurisdictionIdList;
    }

    public void setJurisdictionIdList(Integer[] jurisdictionIdList) {
        this.jurisdictionIdList = jurisdictionIdList;
    }

    public RoleIdAndJurisdictionIdList() {
    }

    public RoleIdAndJurisdictionIdList(Integer roleId, Integer[] jurisdictionIdList) {
        this.roleId = roleId;
        this.jurisdictionIdList = jurisdictionIdList;
    }
}
