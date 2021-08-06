package com.api.model.butlerApp;

/**
 * 管家app 绿化任务主键id 和 状态
 */
public class ButlerGreenTaskIdAndStatus {
    /**
     * 绿化任务主键id
     */
    private Integer greenTaskId;
    /**
     * 状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerGreenTaskIdAndStatus{" +
                "greenTaskId=" + greenTaskId +
                ", status=" + status +
                '}';
    }

    public Integer getGreenTaskId() {
        return greenTaskId;
    }

    public void setGreenTaskId(Integer greenTaskId) {
        this.greenTaskId = greenTaskId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerGreenTaskIdAndStatus() {
    }

    public ButlerGreenTaskIdAndStatus(Integer greenTaskId, Integer status) {
        this.greenTaskId = greenTaskId;
        this.status = status;
    }
}
