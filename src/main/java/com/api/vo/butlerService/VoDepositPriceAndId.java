package com.api.vo.butlerService;

import java.math.BigDecimal;

/**
 * 押金管理主键id和装修押金
 */
public class VoDepositPriceAndId {
    /**
     * 押金管理主键id
     */
    private Integer id;
    /**
     * 装修押金
     */
    private BigDecimal depositPrice;

    @Override
    public String toString() {
        return "VoDepositPriceAndId{" +
                "id=" + id +
                ", depositPrice=" + depositPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public VoDepositPriceAndId() {
    }

    public VoDepositPriceAndId(Integer id, BigDecimal depositPrice) {
        this.id = id;
        this.depositPrice = depositPrice;
    }
}
