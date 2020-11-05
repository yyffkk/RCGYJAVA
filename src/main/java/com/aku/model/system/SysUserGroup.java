package com.aku.model.system;

/**
 * 用户与用户组关联表
 */
public class SysUserGroup {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户组ID
     */
    private Integer groupId;

    @Override
    public String toString() {
        return "SysUserGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public SysUserGroup() {
    }

    public SysUserGroup(Integer id, Integer userId, Integer groupId) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
    }
}
