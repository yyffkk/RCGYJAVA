package com.api.vo.dataStatistics;

import java.math.BigDecimal;

/**
 * 数据统计 缴费统计Vo 回显
 */
public class DSPaymentStatisticsVo {
    /**
     * 应缴金额
     */
    private BigDecimal shouldPayPrice;
    /**
     * 已缴金额
     */
    private BigDecimal payPrice;
    /**
     * 年份
     */
    private Integer years;
    /**
     * 月份
     */
    private Integer months;

    @Override
    public String toString() {
        return "PaymentStatisticsVo{" +
                "shouldPayPrice=" + shouldPayPrice +
                ", payPrice=" + payPrice +
                ", years=" + years +
                ", months=" + months +
                '}';
    }

    public BigDecimal getShouldPayPrice() {
        return shouldPayPrice;
    }

    public void setShouldPayPrice(BigDecimal shouldPayPrice) {
        this.shouldPayPrice = shouldPayPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public DSPaymentStatisticsVo() {
    }

    public DSPaymentStatisticsVo(BigDecimal shouldPayPrice, BigDecimal payPrice, Integer years, Integer months) {
        this.shouldPayPrice = shouldPayPrice;
        this.payPrice = payPrice;
        this.years = years;
        this.months = months;
    }
}
