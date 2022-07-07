package com.api.model.alipay;

import java.math.BigDecimal;

/**
 * 房产id 和 预付款充值金额
 */
public class EstateIdAndAdvancePaymentPrice {
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 预付款充值金额
     */
    private BigDecimal advancePaymentPrice;

    @Override
    public String toString() {
        return "EstateIdAndAdvancePaymentPrice{" +
                "estateId=" + estateId +
                ", advancePaymentPrice=" + advancePaymentPrice +
                '}';
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public BigDecimal getAdvancePaymentPrice() {
        return advancePaymentPrice;
    }

    public void setAdvancePaymentPrice(BigDecimal advancePaymentPrice) {
        this.advancePaymentPrice = advancePaymentPrice;
    }

    public EstateIdAndAdvancePaymentPrice() {
    }

    public EstateIdAndAdvancePaymentPrice(Integer estateId, BigDecimal advancePaymentPrice) {
        this.estateId = estateId;
        this.advancePaymentPrice = advancePaymentPrice;
    }
}
