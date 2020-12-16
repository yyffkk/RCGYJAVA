package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物业收费标准明细 信息
 */
public class SysChargesTemplateDetail {
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
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysChargesTemplateDetail{" +
                "id=" + id +
                ", chargesTemplateId=" + chargesTemplateId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", otherFee=" + otherFee +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysChargesTemplateDetail() {
    }

    public SysChargesTemplateDetail(Integer id, Integer chargesTemplateId, String name, BigDecimal unitPrice, Integer type, BigDecimal otherFee, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.chargesTemplateId = chargesTemplateId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type;
        this.otherFee = otherFee;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
