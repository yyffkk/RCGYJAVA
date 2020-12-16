package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物业收费标准明细 Vo list 回显
 */
public class VoChargesTemplateDetail {
    /**
     * 物业收费标准明细主键id
     */
    private Integer id;
    /**
     * 物业收费标准模版 状态
     */
    private Integer Status;
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
     * 创建人姓名
     */
    private String createName;
    /**
     * 更新时间（如果修改时间为空，则为创建时间）
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "VoChargesTemplateDetail{" +
                "id=" + id +
                ", Status=" + Status +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", otherFee=" + otherFee +
                ", createName='" + createName + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public VoChargesTemplateDetail() {
    }

    public VoChargesTemplateDetail(Integer id, Integer status, String name, BigDecimal unitPrice, Integer type, BigDecimal otherFee, String createName, Date modifyDate) {
        this.id = id;
        Status = status;
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type;
        this.otherFee = otherFee;
        this.createName = createName;
        this.modifyDate = modifyDate;
    }
}
