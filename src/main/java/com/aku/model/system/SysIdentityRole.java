package com.aku.model.system;

/**
 * 身份角色关联表
 */
public class SysIdentityRole {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 身份id
     */
    private Integer identityId;
    /**
     * 角色id
     */
    private Integer roleId;

    @Override
    public String toString() {
        return "SysIdentityRole{" +
                "id=" + id +
                ", identityId=" + identityId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysIdentityRole() {
    }

    public SysIdentityRole(Integer id, Integer identityId, Integer roleId) {
        this.id = id;
        this.identityId = identityId;
        this.roleId = roleId;
    }
}
