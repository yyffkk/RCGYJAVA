package com.api.model.operationManagement;

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

    public AttendanceRecord() {
    }

    public AttendanceRecord(Integer id, Date startClockDate, Date endClockDate, Integer clockId, Date cardReplacementDate, Integer operator, Date createDate) {
        this.id = id;
        this.startClockDate = startClockDate;
        this.endClockDate = endClockDate;
        this.clockId = clockId;
        this.cardReplacementDate = cardReplacementDate;
        this.operator = operator;
        this.createDate = createDate;
    }
}
