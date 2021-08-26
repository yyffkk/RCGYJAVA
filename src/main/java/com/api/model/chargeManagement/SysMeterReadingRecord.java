package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 抄表记录管理
 */
public class SysMeterReadingRecord {
    /**
     * 抄表记录主键id
     */
    private Integer id;
    /**
     * 抄表用量（该区间用量）
     */
    private BigDecimal consumption;
    /**
     * 抄表类型（1.水量，2.电量）
     */
    private Integer type;
    /**
     * 单位
     */
    private String unit;
    /**
     * 抄表记录量（当前量）
     */
    private BigDecimal recordingQuantity;
    /**
     * 抄表区间开始
     */
    private Date startDate;
    /**
     * 抄表区间结束
     */
    private Date endDate;
    /**
     * 数据状态：1.正常，2.异常
     */
    private Integer dataStatus;
    /**
     * 账单状态：1.未创建，2.已创建
     */
    private Integer billStatus;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysMeterReadingRecord{" +
                "id=" + id +
                ", consumption=" + consumption +
                ", type=" + type +
                ", unit='" + unit + '\'' +
                ", recordingQuantity=" + recordingQuantity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dataStatus=" + dataStatus +
                ", billStatus=" + billStatus +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getRecordingQuantity() {
        return recordingQuantity;
    }

    public void setRecordingQuantity(BigDecimal recordingQuantity) {
        this.recordingQuantity = recordingQuantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SysMeterReadingRecord() {
    }

    public SysMeterReadingRecord(Integer id, BigDecimal consumption, Integer type, String unit, BigDecimal recordingQuantity, Date startDate, Date endDate, Integer dataStatus, Integer billStatus, Date createDate) {
        this.id = id;
        this.consumption = consumption;
        this.type = type;
        this.unit = unit;
        this.recordingQuantity = recordingQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dataStatus = dataStatus;
        this.billStatus = billStatus;
        this.createDate = createDate;
    }
}
