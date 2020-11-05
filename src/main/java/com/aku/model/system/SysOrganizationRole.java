package com.aku.model.system;

/**
 * 组织角色表
 */
public class SysOrganizationRole {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 组织id
     */
    private Integer organization;
    /**
     * 角色id
     */
    private Integer roleId;

    @Override
    public String toString() {
        return "SysOrganizationRole{" +
                "id=" + id +
                ", organization=" + organization +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysOrganizationRole() {
    }

    public SysOrganizationRole(Integer id, Integer organization, Integer roleId) {
        this.id = id;
        this.organization = organization;
        this.roleId = roleId;
    }
}
