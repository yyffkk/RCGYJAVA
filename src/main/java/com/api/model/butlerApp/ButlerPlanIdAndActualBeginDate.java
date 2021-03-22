package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 巡检计划主键id 和 实际开始时间
 */
public class ButlerPlanIdAndActualBeginDate {
    /**
     * 巡检计划主键id
     */
    private Integer planId;
    /***
     * 实际开始时间
     */
    private Date actualBeginDate;

    @Override
    public String toString() {
        return "ButlerPlanIdAndActualBeginDate{" +
                "planId=" + planId +
                ", actualBeginDate=" + actualBeginDate +
                '}';
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public ButlerPlanIdAndActualBeginDate() {
    }

    public ButlerPlanIdAndActualBeginDate(Integer planId, Date actualBeginDate) {
        this.planId = planId;
        this.actualBeginDate = actualBeginDate;
    }
}
