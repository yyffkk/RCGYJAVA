package com.api.model.system;

/**
 * 角色权限关联表
 */
public class SysRoleJurisdiction {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer jurisdictionId;
    /**
     * 系统编码功能id
     */
    private Integer actionId;

    @Override
    public String toString() {
        return "SysRoleJurisdiction{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", jurisdictionId=" + jurisdictionId +
                ", actionId=" + actionId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public SysRoleJurisdiction() {
    }

    public SysRoleJurisdiction(Integer id, Integer roleId, Integer jurisdictionId, Integer actionId) {
        this.id = id;
        this.roleId = roleId;
        this.jurisdictionId = jurisdictionId;
        this.actionId = actionId;
    }
}
