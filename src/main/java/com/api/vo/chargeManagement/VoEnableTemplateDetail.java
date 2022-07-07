package com.api.vo.chargeManagement;

import java.math.BigDecimal;

/**
 * 已开启的收费标准明细信息
 */
public class VoEnableTemplateDetail {
    /**
     * 收费标准明细主键id
     */
    private Integer id;
    /**
     * 收费标准明细名称
     */
    private String name;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 计费单位（1.元/月 平方米，2.元/ 立方米，3.元/ 次）
     */
    private Integer type;

    @Override
    public String toString() {
        return "VoEnableTemplateDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public VoEnableTemplateDetail() {
    }

    public VoEnableTemplateDetail(Integer id, String name, BigDecimal unitPrice, Integer type) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type;
    }
}
