package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 抄表公摊账单详情
 */
public class SysMeterReadingShareBillDetails {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 公摊账单主键id
     */
    private Integer shareBillId;
    /**
     * 房产主键id
     */
    private Integer estateId;
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
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysMeterReadingShareBillDetails{" +
                "id=" + id +
                ", shareBillId=" + shareBillId +
                ", estateId=" + estateId +
                ", houseArea=" + houseArea +
                ", amountPayable=" + amountPayable +
                ", paidAmount=" + paidAmount +
                ", remainingUnpaidAmount=" + remainingUnpaidAmount +
                ", status=" + status +
                ", rate=" + rate +
                ", paymentPeriod=" + paymentPeriod +
                ", paymentTime=" + paymentTime +
                ", type=" + type +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareBillId() {
        return shareBillId;
    }

    public void setShareBillId(Integer shareBillId) {
        this.shareBillId = shareBillId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SysMeterReadingShareBillDetails() {
    }

    public SysMeterReadingShareBillDetails(Integer id, Integer shareBillId, Integer estateId, BigDecimal houseArea, BigDecimal amountPayable, BigDecimal paidAmount, BigDecimal remainingUnpaidAmount, Integer status, BigDecimal rate, Date paymentPeriod, Date paymentTime, Integer type, Integer createId, Date createDate) {
        this.id = id;
        this.shareBillId = shareBillId;
        this.estateId = estateId;
        this.houseArea = houseArea;
        this.amountPayable = amountPayable;
        this.paidAmount = paidAmount;
        this.remainingUnpaidAmount = remainingUnpaidAmount;
        this.status = status;
        this.rate = rate;
        this.paymentPeriod = paymentPeriod;
        this.paymentTime = paymentTime;
        this.type = type;
        this.createId = createId;
        this.createDate = createDate;
    }
}
