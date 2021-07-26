package com.api.model.operationManagement;

import java.util.Date;
import java.sql.Time;

/**
 * 考勤排班计划model
 */
public class SysAttendanceSchedulingPlan {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 计划名称
     */
    private String name;
    /**
     * 第一时段开始（第一时段全填或都不填）
     */
    private Time firstTimeStart;
    /**
     * 第一时段结束
     */
    private Time firstTimeEnd;
    /**
     * 第二时段开始（第二时段全填或都不填）
     */
    private Time secondTimeStart;
    /**
     * 第二时段结束
     */
    private Time secondTimeEnd;
    /**
     * 考勤小组主键id
     */
    private Integer teamId;
    /**
     * 状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人id
     */
    private Integer createId;

    @Override
    public String toString() {
        return "SysAttendanceSchedulingPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstTimeStart=" + firstTimeStart +
                ", firstTimeEnd=" + firstTimeEnd +
                ", secondTimeStart=" + secondTimeStart +
                ", secondTimeEnd=" + secondTimeEnd +
                ", teamId=" + teamId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", createId=" + createId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getFirstTimeStart() {
        return firstTimeStart;
    }

    public void setFirstTimeStart(Time firstTimeStart) {
        this.firstTimeStart = firstTimeStart;
    }

    public Time getFirstTimeEnd() {
        return firstTimeEnd;
    }

    public void setFirstTimeEnd(Time firstTimeEnd) {
        this.firstTimeEnd = firstTimeEnd;
    }

    public Time getSecondTimeStart() {
        return secondTimeStart;
    }

    public void setSecondTimeStart(Time secondTimeStart) {
        this.secondTimeStart = secondTimeStart;
    }

    public Time getSecondTimeEnd() {
        return secondTimeEnd;
    }

    public void setSecondTimeEnd(Time secondTimeEnd) {
        this.secondTimeEnd = secondTimeEnd;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public SysAttendanceSchedulingPlan() {
    }

    public SysAttendanceSchedulingPlan(Integer id, String name, Time firstTimeStart, Time firstTimeEnd, Time secondTimeStart, Time secondTimeEnd, Integer teamId, Integer status, Date createDate, Integer createId) {
        this.id = id;
        this.name = name;
        this.firstTimeStart = firstTimeStart;
        this.firstTimeEnd = firstTimeEnd;
        this.secondTimeStart = secondTimeStart;
        this.secondTimeEnd = secondTimeEnd;
        this.teamId = teamId;
        this.status = status;
        this.createDate = createDate;
        this.createId = createId;
    }
}
