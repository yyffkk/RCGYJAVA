package com.api.model.butlerApp;

/**
 * 管家app 卫生任务主键id 和 状态
 */
public class ButlerHygieneTaskIdAndStatus {
    /**
     * 卫生任务主键id
     */
    private Integer hygieneTaskId;
    /**
     * 状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerHygieneTaskIdAndStatus{" +
                "hygieneTaskId=" + hygieneTaskId +
                ", status=" + status +
                '}';
    }

    public Integer getHygieneTaskId() {
        return hygieneTaskId;
    }

    public void setHygieneTaskId(Integer hygieneTaskId) {
        this.hygieneTaskId = hygieneTaskId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerHygieneTaskIdAndStatus() {
    }

    public ButlerHygieneTaskIdAndStatus(Integer hygieneTaskId, Integer status) {
        this.hygieneTaskId = hygieneTaskId;
        this.status = status;
    }
}
