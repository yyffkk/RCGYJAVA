package com.api.model.butlerApp;

import java.util.Date;

/**
 * 巡检执行点主键id 和 巡检点完成时间
 */
public class ButlerPointIdAndCompleteDate {
    /**
     * 巡检执行点主键id
     */
    private Integer pointId;
    /**
     * 巡检点完成时间
     */
    private Date completeDate;

    @Override
    public String toString() {
        return "ButlerPointIdAndCompleteDate{" +
                "pointId=" + pointId +
                ", completeDate=" + completeDate +
                '}';
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public ButlerPointIdAndCompleteDate() {
    }

    public ButlerPointIdAndCompleteDate(Integer pointId, Date completeDate) {
        this.pointId = pointId;
        this.completeDate = completeDate;
    }
}
