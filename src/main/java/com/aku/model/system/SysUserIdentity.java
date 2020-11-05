package com.aku.model.system;

/**
 * 用户身份关联表
 */
public class SysUserIdentity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 身份ID
     */
    private Integer identity;

    @Override
    public String toString() {
        return "SysUserIdentity{" +
                "id=" + id +
                ", userId=" + userId +
                ", identity=" + identity +
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

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public SysUserIdentity() {
    }

    public SysUserIdentity(Integer id, Integer userId, Integer identity) {
        this.id = id;
        this.userId = userId;
        this.identity = identity;
    }
}
