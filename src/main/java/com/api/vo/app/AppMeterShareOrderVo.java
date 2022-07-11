package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app抄表公摊订单Vo 回显
 */
public class AppMeterShareOrderVo {
    /**
     * 缴纳金额
     */
    private BigDecimal payPrice;
    /**
     * 缴费时间
     */
    private Date paymentTime;
    /**
     * 付款方式（1.支付宝，2.微信，3.现金，3.pos）
     */
    private Integer payType;
    /**
     * 公摊账单详情支付单号
     */
    private String code;
    /**
     * 账单月份
     */
    private String months;
    /**
     * 计费周期有效开始时间
     */
    private Date effectiveTimeStart;
    /**
     * 计费周期有效结束时间
     */
    private Date effectiveTimeEnd;
    /**
     * 公摊单价（（总用量-住户总费用）/住户面积）
     */
    private BigDecimal shareUnitPrice;
    /**
     * 建筑面积（室内面积）
     */
    private BigDecimal indoorArea;

    @Override
    public String toString() {
        return "AppMeterShareOrderVo{" +
                "payPrice=" + payPrice +
                ", paymentTime=" + paymentTime +
                ", payType=" + payType +
                ", code='" + code + '\'' +
                ", months='" + months + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", shareUnitPrice=" + shareUnitPrice +
                ", indoorArea=" + indoorArea +
                '}';
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public BigDecimal getShareUnitPrice() {
        return shareUnitPrice;
    }

    public void setShareUnitPrice(BigDecimal shareUnitPrice) {
        this.shareUnitPrice = shareUnitPrice;
    }

    public BigDecimal getIndoorArea() {
        return indoorArea;
    }

    public void setIndoorArea(BigDecimal indoorArea) {
        this.indoorArea = indoorArea;
    }

    public AppMeterShareOrderVo() {
    }

    public AppMeterShareOrderVo(BigDecimal payPrice, Date paymentTime, Integer payType, String code, String months, Date effectiveTimeStart, Date effectiveTimeEnd, BigDecimal shareUnitPrice, BigDecimal indoorArea) {
        this.payPrice = payPrice;
        this.paymentTime = paymentTime;
        this.payType = payType;
        this.code = code;
        this.months = months;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.shareUnitPrice = shareUnitPrice;
        this.indoorArea = indoorArea;
    }
}
