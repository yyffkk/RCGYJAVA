package com.api.vo.app;

import java.math.BigDecimal;
import java.util.List;

/**
 * app押金信息回显
 */
public class AppDepositVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 押金金额
     */
    private BigDecimal depositPrice;
    /**
     * app押金附加费用信息集合回显
     */
    private List<AppDepositAdditionalCostVo> additionalCostVos;

    @Override
    public String toString() {
        return "AppDepositVo{" +
                "id=" + id +
                ", depositPrice=" + depositPrice +
                ", additionalCostVos=" + additionalCostVos +
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

    public List<AppDepositAdditionalCostVo> getAdditionalCostVos() {
        return additionalCostVos;
    }

    public void setAdditionalCostVos(List<AppDepositAdditionalCostVo> additionalCostVos) {
        this.additionalCostVos = additionalCostVos;
    }

    public AppDepositVo() {
    }

    public AppDepositVo(Integer id, BigDecimal depositPrice, List<AppDepositAdditionalCostVo> additionalCostVos) {
        this.id = id;
        this.depositPrice = depositPrice;
        this.additionalCostVos = additionalCostVos;
    }
}
