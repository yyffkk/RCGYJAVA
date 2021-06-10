package com.api.vo.dataStatistics;

import java.util.Date;

/**
 * 数据统计 巡更记录
 */
public class DSInspectionRecord {
    /**
     * 巡检执行情况主键id
     */
    private Integer id;
    /**
     * 计划当次巡检开始时间
     */
    private Date beginDate;
    /**
     * 计划当次巡检结束时间
     */
    private Date endDate;
    /**
     * 实际当次巡检开始时间
     */
    private Date actualBeginDate;
    /**
     * 实际当次巡检结束时间
     */
    private Date actualEndDate;
    /**
     * 持续时间，单位为分钟
     */
    private Integer spaceTime;
    /**
     * 巡检状态（1.未巡检，2.巡检中，3.已巡检）
     */
    private Integer status;
    /**
     * 巡更进度
     */
    private Integer progress;

    @Override
    public String toString() {
        return "DSInspectionRecord{" +
                "id=" + id +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                ", spaceTime=" + spaceTime +
                ", status=" + status +
                ", progress=" + progress +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public DSInspectionRecord() {
    }

    public DSInspectionRecord(Integer id, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate, Integer spaceTime, Integer status, Integer progress) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
        this.spaceTime = spaceTime;
        this.status = status;
        this.progress = progress;
    }
}
