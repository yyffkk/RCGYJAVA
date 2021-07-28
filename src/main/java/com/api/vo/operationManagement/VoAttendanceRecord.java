package com.api.vo.operationManagement;

import java.sql.Time;
import java.util.Date;

/**
 * 考勤打卡记录Vo list 回显
 */
public class VoAttendanceRecord {
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
     * 补卡时间
     */
    private Date cardReplacementDate;
    /**
     * 补卡操作人
     */
    private String operatorName;
    /**
     * 打卡人姓名
     */
    private String clockName;
    /**
     * 打卡人手机号
     */
    private String clockTel;
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
        return "VoAttendanceRecord{" +
                "id=" + id +
                ", startClockDate=" + startClockDate +
                ", endClockDate=" + endClockDate +
                ", cardReplacementDate=" + cardReplacementDate +
                ", operatorName='" + operatorName + '\'' +
                ", clockName='" + clockName + '\'' +
                ", clockTel='" + clockTel + '\'' +
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

    public Date getCardReplacementDate() {
        return cardReplacementDate;
    }

    public void setCardReplacementDate(Date cardReplacementDate) {
        this.cardReplacementDate = cardReplacementDate;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getClockName() {
        return clockName;
    }

    public void setClockName(String clockName) {
        this.clockName = clockName;
    }

    public String getClockTel() {
        return clockTel;
    }

    public void setClockTel(String clockTel) {
        this.clockTel = clockTel;
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

    public VoAttendanceRecord() {
    }

    public VoAttendanceRecord(Integer id, Date startClockDate, Date endClockDate, Date cardReplacementDate, String operatorName, String clockName, String clockTel, Date createDate, Integer status, Time firstTimeStart, Time firstTimeEnd, Time secondTimeStart, Time secondTimeEnd) {
        this.id = id;
        this.startClockDate = startClockDate;
        this.endClockDate = endClockDate;
        this.cardReplacementDate = cardReplacementDate;
        this.operatorName = operatorName;
        this.clockName = clockName;
        this.clockTel = clockTel;
        this.createDate = createDate;
        this.status = status;
        this.firstTimeStart = firstTimeStart;
        this.firstTimeEnd = firstTimeEnd;
        this.secondTimeStart = secondTimeStart;
        this.secondTimeEnd = secondTimeEnd;
    }
}
