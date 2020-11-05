package com.aku.model.system;

/**
 * 用户组织关联表
 */
public class SysUserOrganization {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 组织ID
     */
    private Integer organizationId;

    @Override
    public String toString() {
        return "SysUserOrganization{" +
                "id=" + id +
                ", userId=" + userId +
                ", organizationId=" + organizationId +
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public SysUserOrganization() {
    }

    public SysUserOrganization(Integer id, Integer userId, Integer organizationId) {
        this.id = id;
        this.userId = userId;
        this.organizationId = organizationId;
    }
}
