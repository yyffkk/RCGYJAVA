package com.api.vo.chargeManagement;

import java.math.BigDecimal;

/**
 * 收费标准附加费用信息
 */
public class VoChargesTemplateAdditionalCost {
    /**
     * 主键id
     */
    private Integer id;
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
        return "VoChargesTemplateAdditionalCost{" +
                "id=" + id +
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

    public VoChargesTemplateAdditionalCost() {
    }

    public VoChargesTemplateAdditionalCost(Integer id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
