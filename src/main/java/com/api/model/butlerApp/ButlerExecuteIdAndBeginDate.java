package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 执行情况主键id 和当前巡检实际开始时间
 */
public class ButlerExecuteIdAndBeginDate {
    /**
     * 执行情况主键id
     */
    private Integer executeId;
    /**
     * 实际当次巡检开始时间
     */
    private Date actualBeginDate;

    @Override
    public String toString() {
        return "ButlerExecuteIdAndBeginDate{" +
                "executeId=" + executeId +
                ", actualBeginDate=" + actualBeginDate +
                '}';
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public ButlerExecuteIdAndBeginDate() {
    }

    public ButlerExecuteIdAndBeginDate(Integer executeId, Date actualBeginDate) {
        this.executeId = executeId;
        this.actualBeginDate = actualBeginDate;
    }
}
