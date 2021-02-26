package com.api.model.chargeManagement;

import java.math.BigDecimal;

/**
 * 物业收费标准附加费用
 */
public class SysChargesTemplateAdditionalCost {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 收费标准明细主键id
     */
    private Integer chargesTemplateDetailId;
    /**
     * 附加费用名称
     */
    private String name;
    /**
     * 附加费用金额
     */
    private BigDecimal cost;

    @Override
    public String toString() {
        return "SysChargesTemplateAdditionalCost{" +
                "id=" + id +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public SysChargesTemplateAdditionalCost() {
    }

    public SysChargesTemplateAdditionalCost(Integer id, Integer chargesTemplateDetailId, String name, BigDecimal cost) {
        this.id = id;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.name = name;
        this.cost = cost;
    }
}
