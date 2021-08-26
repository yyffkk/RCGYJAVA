package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 抄表记录Vo list  回显
 */
public class VoMeterReadingRecord {
    /**
     * 抄表记录主键id
     */
    private Integer id;
    /**
     * 抄表月份
     */
    private String months;
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
        return "VoMeterReadingRecord{" +
                "id=" + id +
                ", months='" + months + '\'' +
                ", consumption=" + consumption +
                ", type=" + type +
                ", unit='" + unit + '\'' +
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

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
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

    public VoMeterReadingRecord() {
    }

    public VoMeterReadingRecord(Integer id, String months, BigDecimal consumption, Integer type, String unit, Date startDate, Date endDate, Integer dataStatus, Integer billStatus, Date createDate) {
        this.id = id;
        this.months = months;
        this.consumption = consumption;
        this.type = type;
        this.unit = unit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dataStatus = dataStatus;
        this.billStatus = billStatus;
        this.createDate = createDate;
    }
}
