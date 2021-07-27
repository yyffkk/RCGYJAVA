package com.api.model.operationManagement;

import java.sql.Time;

/**
 * 排班计划详情model
 */
public class SysAttendanceSchedulingPlanDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 考勤排班计划主键id
     */
    private Integer attendanceSchedulingPlanId;
    /**
     * 工作日，1代表周一，以此类推
     */
    private Integer workingDays;
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

    @Override
    public String toString() {
        return "SysAttendanceSchedulingPlanDetail{" +
                "id=" + id +
                ", attendanceSchedulingPlanId=" + attendanceSchedulingPlanId +
                ", workingDays=" + workingDays +
                ", firstTimeStart=" + firstTimeStart +
                ", firstTimeEnd=" + firstTimeEnd +
                ", secondTimeStart=" + secondTimeStart +
                ", secondTimeEnd=" + secondTimeEnd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceSchedulingPlanId() {
        return attendanceSchedulingPlanId;
    }

    public void setAttendanceSchedulingPlanId(Integer attendanceSchedulingPlanId) {
        this.attendanceSchedulingPlanId = attendanceSchedulingPlanId;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
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

    public SysAttendanceSchedulingPlanDetail() {
    }

    public SysAttendanceSchedulingPlanDetail(Integer id, Integer attendanceSchedulingPlanId, Integer workingDays, Time firstTimeStart, Time firstTimeEnd, Time secondTimeStart, Time secondTimeEnd) {
        this.id = id;
        this.attendanceSchedulingPlanId = attendanceSchedulingPlanId;
        this.workingDays = workingDays;
        this.firstTimeStart = firstTimeStart;
        this.firstTimeEnd = firstTimeEnd;
        this.secondTimeStart = secondTimeStart;
        this.secondTimeEnd = secondTimeEnd;
    }
}
