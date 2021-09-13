package com.api.model.alipay;

import java.math.BigDecimal;

/**
 * 抄表分摊详情订单清单信息
 */
public class SysMeterReadingShareDetailsOrderList {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 抄表公摊订单主键id
     */
    private Integer meterShareOrderId;
    /**
     * 抄表公摊详情主键id
     */
    private Integer meterShareDetailsId;
    /**
     * 抄表公摊缴费金额
     */
    private BigDecimal payPrice;

    @Override
    public String toString() {
        return "SysMeterReadingShareDetailsOrderList{" +
                "id=" + id +
                ", meterShareOrderId=" + meterShareOrderId +
                ", meterShareDetailsId=" + meterShareDetailsId +
                ", payPrice=" + payPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeterShareOrderId() {
        return meterShareOrderId;
    }

    public void setMeterShareOrderId(Integer meterShareOrderId) {
        this.meterShareOrderId = meterShareOrderId;
    }

    public Integer getMeterShareDetailsId() {
        return meterShareDetailsId;
    }

    public void setMeterShareDetailsId(Integer meterShareDetailsId) {
        this.meterShareDetailsId = meterShareDetailsId;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public SysMeterReadingShareDetailsOrderList() {
    }

    public SysMeterReadingShareDetailsOrderList(Integer id, Integer meterShareOrderId, Integer meterShareDetailsId, BigDecimal payPrice) {
        this.id = id;
        this.meterShareOrderId = meterShareOrderId;
        this.meterShareDetailsId = meterShareDetailsId;
        this.payPrice = payPrice;
    }
}
