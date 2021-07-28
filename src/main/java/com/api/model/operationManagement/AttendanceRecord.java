package com.api.model.operationManagement;

import java.sql.Time;
import java.util.Date;

/**
 * 考勤记录model
 */
public class AttendanceRecord {
    /**
     * 考勤打卡记录主键id
     */
    private Integer id;
    /**
     * 上班打卡时间
     */
    private Date startClockDate;
    /**
     * 下班打卡时间
     */
    private Date endClockDate;
    /**
     * 打卡人id
     */
    private Integer clockId;
    /**
     * 补卡时间
     */
    private Date cardReplacementDate;
    /**
     * 补卡操作人id
     */
    private Integer operator;
    /**
     * 考勤记录创建时间
     */
    private Date createDate;
    /**
     * 状态：1.放假日（节假），2.工作日，3.休息日（双休）
     */
    private Integer status;
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
        return "AttendanceRecord{" +
                "id=" + id +
                ", startClockDate=" + startClockDate +
                ", endClockDate=" + endClockDate +
                ", clockId=" + clockId +
                ", cardReplacementDate=" + cardReplacementDate +
                ", operator=" + operator +
                ", createDate=" + createDate +
                ", status=" + status +
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

    public Date getStartClockDate() {
        return startClockDate;
    }

    public void setStartClockDate(Date startClockDate) {
        this.startClockDate = startClockDate;
    }

    public Date getEndClockDate() {
        return endClockDate;
    }

    public void setEndClockDate(Date endClockDate) {
        this.endClockDate = endClockDate;
    }

    public Integer getClockId() {
        return clockId;
    }

    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }

    public Date getCardReplacementDate() {
        return cardReplacementDate;
    }

    public void setCardReplacementDate(Date cardReplacementDate) {
        this.cardReplacementDate = cardReplacementDate;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public AttendanceRecord() {
    }

    public AttendanceRecord(Integer id, Date startClockDate, Date endClockDate, Integer clockId, Date cardReplacementDate, Integer operator, Date createDate, Integer status, Time firstTimeStart, Time firstTimeEnd, Time secondTimeStart, Time secondTimeEnd) {
        this.id = id;
        this.startClockDate = startClockDate;
        this.endClockDate = endClockDate;
        this.clockId = clockId;
        this.cardReplacementDate = cardReplacementDate;
        this.operator = operator;
        this.createDate = createDate;
        this.status = status;
        this.firstTimeStart = firstTimeStart;
        this.firstTimeEnd = firstTimeEnd;
        this.secondTimeStart = secondTimeStart;
        this.secondTimeEnd = secondTimeEnd;
    }
}
