package com.api.model.chargeManagement;

import java.math.BigDecimal;

/**
 * 日常缴费订单清单信息
 */
public class DailyPaymentOrderList {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 缴费订单主键id
     */
    private Integer dailyPaymentOrderId;
    /**
     * 缴费主键id
     */
    private Integer dailyPaymentId;
    /**
     * 缴费金额
     */
    private BigDecimal dailyPaymentPrice;

    @Override
    public String toString() {
        return "DailyPaymentOrderList{" +
                "id=" + id +
                ", dailyPaymentOrderId=" + dailyPaymentOrderId +
                ", dailyPaymentId=" + dailyPaymentId +
                ", dailyPaymentPrice=" + dailyPaymentPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDailyPaymentOrderId() {
        return dailyPaymentOrderId;
    }

    public void setDailyPaymentOrderId(Integer dailyPaymentOrderId) {
        this.dailyPaymentOrderId = dailyPaymentOrderId;
    }

    public Integer getDailyPaymentId() {
        return dailyPaymentId;
    }

    public void setDailyPaymentId(Integer dailyPaymentId) {
        this.dailyPaymentId = dailyPaymentId;
    }

    public BigDecimal getDailyPaymentPrice() {
        return dailyPaymentPrice;
    }

    public void setDailyPaymentPrice(BigDecimal dailyPaymentPrice) {
        this.dailyPaymentPrice = dailyPaymentPrice;
    }

    public DailyPaymentOrderList() {
    }

    public DailyPaymentOrderList(Integer id, Integer dailyPaymentOrderId, Integer dailyPaymentId, BigDecimal dailyPaymentPrice) {
        this.id = id;
        this.dailyPaymentOrderId = dailyPaymentOrderId;
        this.dailyPaymentId = dailyPaymentId;
        this.dailyPaymentPrice = dailyPaymentPrice;
    }
}
