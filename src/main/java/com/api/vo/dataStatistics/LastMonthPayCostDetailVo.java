package com.api.vo.dataStatistics;

import java.math.BigDecimal;

/**
 * 上个月物业缴费情况Vo 回显
 */
public class LastMonthPayCostDetailVo {
    /**
     * 上月账单已缴金额
     */
    private BigDecimal lastMonthPayPrice;
    /**
     * 上月账单未缴金额
     */
    private BigDecimal lastMonthUnpaidPrice;
    /**
     * 上月账单应缴金额
     */
    private BigDecimal lastMonthShouldPayPrice;
    /**
     * 上月账单未缴户数
     */
    private BigDecimal lastMonthUnpaidHouseholds;

    @Override
    public String toString() {
        return "LastMonthPayCostDetailVo{" +
                "lastMonthPayPrice=" + lastMonthPayPrice +
                ", lastMonthUnpaidPrice=" + lastMonthUnpaidPrice +
                ", lastMonthShouldPayPrice=" + lastMonthShouldPayPrice +
                ", lastMonthUnpaidHouseholds=" + lastMonthUnpaidHouseholds +
                '}';
    }

    public BigDecimal getLastMonthPayPrice() {
        return lastMonthPayPrice;
    }

    public void setLastMonthPayPrice(BigDecimal lastMonthPayPrice) {
        this.lastMonthPayPrice = lastMonthPayPrice;
    }

    public BigDecimal getLastMonthUnpaidPrice() {
        return lastMonthUnpaidPrice;
    }

    public void setLastMonthUnpaidPrice(BigDecimal lastMonthUnpaidPrice) {
        this.lastMonthUnpaidPrice = lastMonthUnpaidPrice;
    }

    public BigDecimal getLastMonthShouldPayPrice() {
        return lastMonthShouldPayPrice;
    }

    public void setLastMonthShouldPayPrice(BigDecimal lastMonthShouldPayPrice) {
        this.lastMonthShouldPayPrice = lastMonthShouldPayPrice;
    }

    public BigDecimal getLastMonthUnpaidHouseholds() {
        return lastMonthUnpaidHouseholds;
    }

    public void setLastMonthUnpaidHouseholds(BigDecimal lastMonthUnpaidHouseholds) {
        this.lastMonthUnpaidHouseholds = lastMonthUnpaidHouseholds;
    }

    public LastMonthPayCostDetailVo() {
    }

    public LastMonthPayCostDetailVo(BigDecimal lastMonthPayPrice, BigDecimal lastMonthUnpaidPrice, BigDecimal lastMonthShouldPayPrice, BigDecimal lastMonthUnpaidHouseholds) {
        this.lastMonthPayPrice = lastMonthPayPrice;
        this.lastMonthUnpaidPrice = lastMonthUnpaidPrice;
        this.lastMonthShouldPayPrice = lastMonthShouldPayPrice;
        this.lastMonthUnpaidHouseholds = lastMonthUnpaidHouseholds;
    }
}
