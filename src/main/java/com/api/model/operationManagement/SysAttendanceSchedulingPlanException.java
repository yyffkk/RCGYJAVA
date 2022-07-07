package com.api.model.operationManagement;

import java.sql.Time;
import java.util.Date;

/**
 * 考勤排班计划例外情况model
 */
public class SysAttendanceSchedulingPlanException {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 考勤排班计划主键id
     */
    private Integer attendanceSchedulingPlanId;
    /**
     * 日期区间（只取年月日）
     */
    private Date dateRange;
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
     * 类型：1.休假，2.上班
     */
    private Integer type;
    /**
     * 备注
     */
    private String remakes;

    @Override
    public String toString() {
        return "SysAttendanceSchedulingPlanException{" +
                "id=" + id +
                ", attendanceSchedulingPlanId=" + attendanceSchedulingPlanId +
                ", dateRange=" + dateRange +
                ", firstTimeStart=" + firstTimeStart +
                ", firstTimeEnd=" + firstTimeEnd +
                ", secondTimeStart=" + secondTimeStart +
                ", secondTimeEnd=" + secondTimeEnd +
                ", type=" + type +
                ", remakes='" + remakes + '\'' +
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

    public Date getDateRange() {
        return dateRange;
    }

    public void setDateRange(Date dateRange) {
        this.dateRange = dateRange;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public SysAttendanceSchedulingPlanException() {
    }

    public SysAttendanceSchedulingPlanException(Integer id, Integer attendanceSchedulingPlanId, Date dateRange, Time firstTimeStart, Time firstTimeEnd, Time secondTimeStart, Time secondTimeEnd, Integer type, String remakes) {
        this.id = id;
        this.attendanceSchedulingPlanId = attendanceSchedulingPlanId;
        this.dateRange = dateRange;
        this.firstTimeStart = firstTimeStart;
        this.firstTimeEnd = firstTimeEnd;
        this.secondTimeStart = secondTimeStart;
        this.secondTimeEnd = secondTimeEnd;
        this.type = type;
        this.remakes = remakes;
    }
}
