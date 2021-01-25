package com.api.model.chargeManagement;

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

    @Override
    public String toString() {
        return "DailyPaymentOrderList{" +
                "id=" + id +
                ", dailyPaymentOrderId=" + dailyPaymentOrderId +
                ", dailyPaymentId=" + dailyPaymentId +
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

    public DailyPaymentOrderList() {
    }

    public DailyPaymentOrderList(Integer id, Integer dailyPaymentOrderId, Integer dailyPaymentId) {
        this.id = id;
        this.dailyPaymentOrderId = dailyPaymentOrderId;
        this.dailyPaymentId = dailyPaymentId;
    }
}
