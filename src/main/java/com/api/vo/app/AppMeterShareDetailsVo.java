package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app抄表账单详情Vo 回显
 */
public class AppMeterShareDetailsVo {
    /**
     * 抄表账单详情主键id
     */
    private Integer id;
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
     * 滞纳金
     */
    private BigDecimal lateFree;

    @Override
    public String toString() {
        return "AppMeterShareDetailsVo{" +
                "id=" + id +
                ", houseArea=" + houseArea +
                ", amountPayable=" + amountPayable +
                ", paidAmount=" + paidAmount +
                ", remainingUnpaidAmount=" + remainingUnpaidAmount +
                ", status=" + status +
                ", rate=" + rate +
                ", paymentPeriod=" + paymentPeriod +
                ", paymentTime=" + paymentTime +
                ", lateFree=" + lateFree +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getLateFree() {
        return lateFree;
    }

    public void setLateFree(BigDecimal lateFree) {
        this.lateFree = lateFree;
    }

    public AppMeterShareDetailsVo() {
    }

    public AppMeterShareDetailsVo(Integer id, BigDecimal houseArea, BigDecimal amountPayable, BigDecimal paidAmount, BigDecimal remainingUnpaidAmount, Integer status, BigDecimal rate, Date paymentPeriod, Date paymentTime, BigDecimal lateFree) {
        this.id = id;
        this.houseArea = houseArea;
        this.amountPayable = amountPayable;
        this.paidAmount = paidAmount;
        this.remainingUnpaidAmount = remainingUnpaidAmount;
        this.status = status;
        this.rate = rate;
        this.paymentPeriod = paymentPeriod;
        this.paymentTime = paymentTime;
        this.lateFree = lateFree;
    }
}
