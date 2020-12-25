package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 押金退款单信息
 */
public class SysDepositManagementOrder {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 押金管理主键id
     */
    private Integer depositManagementId;
    /**
     * 退款单号
     */
    private String code;
    /**
     * 押金金额
     */
    private BigDecimal depositPrice;
    /**
     * 扣押金
     */
    private BigDecimal depositDeduction;
    /**
     * 退款方式：1.支付宝，2.微信，3.现金，4.pos
     */
    private Integer refundType;
    /**
     * 退款时间
     */
    private Date refundDate;
    /**
     * 退押金
     */
    private BigDecimal refundPrice;
    /**
     *  创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysDepositManagementOrder{" +
                "id=" + id +
                ", depositManagementId=" + depositManagementId +
                ", code='" + code + '\'' +
                ", depositPrice=" + depositPrice +
                ", depositDeduction=" + depositDeduction +
                ", refundType=" + refundType +
                ", refundDate=" + refundDate +
                ", refundPrice=" + refundPrice +
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

    public Integer getDepositManagementId() {
        return depositManagementId;
    }

    public void setDepositManagementId(Integer depositManagementId) {
        this.depositManagementId = depositManagementId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public BigDecimal getDepositDeduction() {
        return depositDeduction;
    }

    public void setDepositDeduction(BigDecimal depositDeduction) {
        this.depositDeduction = depositDeduction;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
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

    public SysDepositManagementOrder() {
    }

    public SysDepositManagementOrder(Integer id, Integer depositManagementId, String code, BigDecimal depositPrice, BigDecimal depositDeduction, Integer refundType, Date refundDate, BigDecimal refundPrice, Integer createId, Date createDate) {
        this.id = id;
        this.depositManagementId = depositManagementId;
        this.code = code;
        this.depositPrice = depositPrice;
        this.depositDeduction = depositDeduction;
        this.refundType = refundType;
        this.refundDate = refundDate;
        this.refundPrice = refundPrice;
        this.createId = createId;
        this.createDate = createDate;
    }
}
