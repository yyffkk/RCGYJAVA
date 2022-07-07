package com.api.model.app;

/**
 * app 用户主键id 和 房产主键id
 */
public class AppUserIdAndExamineId {
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 房产主键id
     */
    private Integer examineId;

    @Override
    public String toString() {
        return "AppUserIdAndExamineId{" +
                "userId=" + userId +
                ", examineId=" + examineId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public AppUserIdAndExamineId() {
    }

    public AppUserIdAndExamineId(Integer userId, Integer examineId) {
        this.userId = userId;
        this.examineId = examineId;
    }
}
