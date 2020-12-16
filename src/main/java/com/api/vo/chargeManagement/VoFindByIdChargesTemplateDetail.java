package com.api.vo.chargeManagement;

import java.math.BigDecimal;

/**
 * 物业收费标准明细Vo findById 回显
 */
public class VoFindByIdChargesTemplateDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版id
     */
    private Integer chargesTemplateId;
    /**
     * 收费名称
     */
    private String name;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 收费类型
     */
    private Integer type;
    /**
     * 附加或固定费用
     */
    private BigDecimal otherFee;

    @Override
    public String toString() {
        return "VoFindByIdChargesTemplateDetail{" +
                "id=" + id +
                ", chargesTemplateId=" + chargesTemplateId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", otherFee=" + otherFee +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargesTemplateId() {
        return chargesTemplateId;
    }

    public void setChargesTemplateId(Integer chargesTemplateId) {
        this.chargesTemplateId = chargesTemplateId;
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

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public VoFindByIdChargesTemplateDetail() {
    }

    public VoFindByIdChargesTemplateDetail(Integer id, Integer chargesTemplateId, String name, BigDecimal unitPrice, Integer type, BigDecimal otherFee) {
        this.id = id;
        this.chargesTemplateId = chargesTemplateId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type;
        this.otherFee = otherFee;
    }
}
