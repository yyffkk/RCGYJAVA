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
    private Integer organizationId;
    /**
     * 角色id
     */
    private Integer roleId;

    @Override
    public String toString() {
        return "SysOrganizationRole{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysOrganizationRole() {
    }

    public SysOrganizationRole(Integer id, Integer organizationId, Integer roleId) {
        this.id = id;
        this.organizationId = organizationId;
        this.roleId = roleId;
    }
}
