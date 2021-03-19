package com.api.model.butlerService;

/**
 * 巡检计划主键id 和 状态
 */
public class PlanIdAndStatus {
    /**
     * 巡检计划主键id
     */
    private Integer planId;
    /**
     * 状态，1.启用 2.停用
     */
    private Integer status;

    @Override
    public String toString() {
        return "PlanIdAndStatus{" +
                "planId=" + planId +
                ", status=" + status +
                '}';
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PlanIdAndStatus() {
    }

    public PlanIdAndStatus(Integer planId, Integer status) {
        this.planId = planId;
        this.status = status;
    }
}
