package com.api.model.chargeManagement;

/**
 * 日常缴费 缴费支付信息
 */
public class DailyPaymentPayInfo {
    /**
     * 缴费主键id
     */
    private Integer dailyPaymentId;
    /**
     * 日常缴费订单信息
     */
    private DailyPaymentOrder dailyPaymentOrder;

    @Override
    public String toString() {
        return "DailyPaymentPayInfo{" +
                "dailyPaymentId=" + dailyPaymentId +
                ", dailyPaymentOrder=" + dailyPaymentOrder +
                '}';
    }

    public Integer getDailyPaymentId() {
        return dailyPaymentId;
    }

    public void setDailyPaymentId(Integer dailyPaymentId) {
        this.dailyPaymentId = dailyPaymentId;
    }

    public DailyPaymentOrder getDailyPaymentOrder() {
        return dailyPaymentOrder;
    }

    public void setDailyPaymentOrder(DailyPaymentOrder dailyPaymentOrder) {
        this.dailyPaymentOrder = dailyPaymentOrder;
    }

    public DailyPaymentPayInfo() {
    }

    public DailyPaymentPayInfo(Integer dailyPaymentId, DailyPaymentOrder dailyPaymentOrder) {
        this.dailyPaymentId = dailyPaymentId;
        this.dailyPaymentOrder = dailyPaymentOrder;
    }
}
