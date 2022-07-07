package com.api.model.butlerApp;

/**
 * 管家app 巡检执行情况主键id 和 执行巡检点编号
 */
public class ButlerExecuteIdAndExecutePointCode {
    /**
     * 巡检执行情况主键id
     */
    private Integer executeId;
    /**
     * 执行巡检点编号
     */
    private String executePointCode;

    @Override
    public String toString() {
        return "ButlerExecuteIdAndExecutePointCode{" +
                "executeId=" + executeId +
                ", executePointCode='" + executePointCode + '\'' +
                '}';
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }

    public String getExecutePointCode() {
        return executePointCode;
    }

    public void setExecutePointCode(String executePointCode) {
        this.executePointCode = executePointCode;
    }

    public ButlerExecuteIdAndExecutePointCode() {
    }

    public ButlerExecuteIdAndExecutePointCode(Integer executeId, String executePointCode) {
        this.executeId = executeId;
        this.executePointCode = executePointCode;
    }
}
