package com.api.model.businessManagement;

/**
 * 用户主键id 和 上级权限id
 */
public class UserIdAndParentId {
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 上级权限id，最上级为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "UserIdAndParentId{" +
                "userId=" + userId +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public UserIdAndParentId() {
    }

    public UserIdAndParentId(Integer userId, Integer parentId) {
        this.userId = userId;
        this.parentId = parentId;
    }
}
