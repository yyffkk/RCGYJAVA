package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 巡检执行计划 Vo list 回显
 */
public class SDInspectionExecutePlanVo {
    /**
     * 巡检执行计划主键id
     */
    private Integer executeId;
    /**
     * 巡检执行计划名称
     */
    private String name;
    /**
     * 计划当次巡检开始时间
     */
    private Date beginDate;
    /**
     * 计划当次巡检结束时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "SDInspectionExecutePlanVo{" +
                "executeId=" + executeId +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SDInspectionExecutePlanVo() {
    }

    public SDInspectionExecutePlanVo(Integer executeId, String name, Date beginDate, Date endDate) {
        this.executeId = executeId;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
