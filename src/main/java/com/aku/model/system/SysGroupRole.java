package com.aku.model.system;

/**
 * 用户组角色关联表
 */
public class SysGroupRole {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户组id
     */
    private Integer groupId;
    /**
     * 角色id
     */
    private Integer roleId;

    @Override
    public String toString() {
        return "SysGroupRole{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysGroupRole() {
    }

    public SysGroupRole(Integer id, Integer groupId, Integer roleId) {
        this.id = id;
        this.groupId = groupId;
        this.roleId = roleId;
    }
}
