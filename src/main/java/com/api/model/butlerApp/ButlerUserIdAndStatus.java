package com.api.model.butlerApp;

/**
 * 用户主键id 和 待办事务状态（1.待处理，2.处理中，3.已处理，4.全部）
 */
public class ButlerUserIdAndStatus {
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 待办事务状态（1.待处理，2.处理中，3.已处理，4.全部）
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerUserIdAndStatus{" +
                "userId=" + userId +
                ", status=" + status +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerUserIdAndStatus() {
    }

    public ButlerUserIdAndStatus(Integer userId, Integer status) {
        this.userId = userId;
        this.status = status;
    }
}
