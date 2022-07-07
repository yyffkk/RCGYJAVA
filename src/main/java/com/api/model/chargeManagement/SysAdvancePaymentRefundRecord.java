package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预缴退款记录
 */
public class SysAdvancePaymentRefundRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 退款金额
     */
    private BigDecimal refundPrice;
    /**
     * 退款方式，1.线下
     */
    private Integer refundType;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysAdvancePaymentRefundRecord{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", refundPrice=" + refundPrice +
                ", refundType=" + refundType +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
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

    public SysAdvancePaymentRefundRecord() {
    }

    public SysAdvancePaymentRefundRecord(Integer id, Integer estateId, BigDecimal refundPrice, Integer refundType, Integer createId, Date createDate) {
        this.id = id;
        this.estateId = estateId;
        this.refundPrice = refundPrice;
        this.refundType = refundType;
        this.createId = createId;
        this.createDate = createDate;
    }
}
