package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 公摊账单明细详情
 */
public class VoMeterReadingShareBillDetails {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 房屋住户
     */
    private String residents;
    /**
     * 房屋面积
     */
    private BigDecimal houseArea;
    /**
     * 应缴金额
     */
    private BigDecimal amountPayable;
    /**
     * 实缴纳金额
     */
    private BigDecimal paidAmount;
    /**
     * 剩余未缴金额
     */
    private BigDecimal remainingUnpaidAmount;
    /**
     * 缴纳状态（1.未缴纳，2.部分缴纳，3.已缴纳）
     */
    private Integer status;
    /**
     * 费率
     */
    private BigDecimal rate;
    /**
     * 缴费期限
     */
    private Date paymentPeriod;
    /**
     * 缴费时间
     */
    private Date paymentTime;
    /**
     * 支付方式（1.微信，2.支付宝，3.现金，4.预缴支付）
     */
    private Integer type;

    @Override
    public String toString() {
        return "VoMeterReadingShareBillDetails{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", roomName='" + roomName + '\'' +
                ", residents='" + residents + '\'' +
                ", houseArea=" + houseArea +
                ", amountPayable=" + amountPayable +
                ", paidAmount=" + paidAmount +
                ", remainingUnpaidAmount=" + remainingUnpaidAmount +
                ", status=" + status +
                ", rate=" + rate +
                ", paymentPeriod=" + paymentPeriod +
                ", paymentTime=" + paymentTime +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getResidents() {
        return residents;
    }

    public void setResidents(String residents) {
        this.residents = residents;
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public BigDecimal getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(BigDecimal amountPayable) {
        this.amountPayable = amountPayable;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getRemainingUnpaidAmount() {
        return remainingUnpaidAmount;
    }

    public void setRemainingUnpaidAmount(BigDecimal remainingUnpaidAmount) {
        this.remainingUnpaidAmount = remainingUnpaidAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(Date paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public VoMeterReadingShareBillDetails() {
    }

    public VoMeterReadingShareBillDetails(Integer id, Date createDate, String roomName, String residents, BigDecimal houseArea, BigDecimal amountPayable, BigDecimal paidAmount, BigDecimal remainingUnpaidAmount, Integer status, BigDecimal rate, Date paymentPeriod, Date paymentTime, Integer type) {
        this.id = id;
        this.createDate = createDate;
        this.roomName = roomName;
        this.residents = residents;
        this.houseArea = houseArea;
        this.amountPayable = amountPayable;
        this.paidAmount = paidAmount;
        this.remainingUnpaidAmount = remainingUnpaidAmount;
        this.status = status;
        this.rate = rate;
        this.paymentPeriod = paymentPeriod;
        this.paymentTime = paymentTime;
        this.type = type;
    }
}
