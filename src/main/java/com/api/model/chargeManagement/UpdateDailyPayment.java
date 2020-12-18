package com.api.model.chargeManagement;

import java.math.BigDecimal;

/**
 * 缴费信息修改信息
 */
public class UpdateDailyPayment {
    /**
     * 缴费订单信息主键id
     */
    private Integer DailyPaymentId;
    /**
     * 支付金额
     */
    private BigDecimal payPrice;

    @Override
    public String toString() {
        return "UpdateDailyPayment{" +
                "DailyPaymentId=" + DailyPaymentId +
                ", payPrice=" + payPrice +
                '}';
    }

    public Integer getDailyPaymentId() {
        return DailyPaymentId;
    }

    public void setDailyPaymentId(Integer dailyPaymentId) {
        DailyPaymentId = dailyPaymentId;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public UpdateDailyPayment() {
    }

    public UpdateDailyPayment(Integer dailyPaymentId, BigDecimal payPrice) {
        DailyPaymentId = dailyPaymentId;
        this.payPrice = payPrice;
    }
}
