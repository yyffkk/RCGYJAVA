package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 巡检执行情况主键id 和 实际当次巡检结束时间
 */
public class ButlerExecuteIdAndActualEndDate {
    /**
     * 巡检执行情况主键id
     */
    private Integer executeId;
    /**
     * 实际当次巡检结束时间
     */
    private Date actualEndDate;

    @Override
    public String toString() {
        return "ButlerExecuteIdAndActualEndDate{" +
                "executeId=" + executeId +
                ", actualEndDate=" + actualEndDate +
                '}';
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public ButlerExecuteIdAndActualEndDate() {
    }

    public ButlerExecuteIdAndActualEndDate(Integer executeId, Date actualEndDate) {
        this.executeId = executeId;
        this.actualEndDate = actualEndDate;
    }
}
