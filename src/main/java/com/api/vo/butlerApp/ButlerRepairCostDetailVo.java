package com.api.vo.butlerApp;

import java.math.BigDecimal;

/**
 * 管家app 报事报修费用明细
 */
public class ButlerRepairCostDetailVo {
    /**
     * 人工费
     */
    private BigDecimal laborCost;
    /**
     * 材料费
     */
    private BigDecimal materialCost;
    /**
     * 总计费
     */
    private BigDecimal totalCost;

    @Override
    public String toString() {
        return "ButlerRepairCostDetailVo{" +
                "laborCost=" + laborCost +
                ", materialCost=" + materialCost +
                ", totalCost=" + totalCost +
                '}';
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public ButlerRepairCostDetailVo() {
    }

    public ButlerRepairCostDetailVo(BigDecimal laborCost, BigDecimal materialCost, BigDecimal totalCost) {
        this.laborCost = laborCost;
        this.materialCost = materialCost;
        this.totalCost = totalCost;
    }
}
