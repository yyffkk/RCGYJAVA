package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用账单详情 Vo list 回显
 */
public class VoExpenseBillDetail {
    /**
     * 缴费主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 缴纳人名称
     */
    private String payPeopleName;
    /**
     * 费用金额
     */
    private BigDecimal costPrice;
    /**
     * 已缴金额
     */
    private BigDecimal paidPrice;
    /**
     * 应收总计
     */
    private BigDecimal totalPrice;
    /**
     * 待缴金额
     */
    private BigDecimal paymentPrice;
    /**
     * 退款金额(备注功能，不参与运算)
     */
    private BigDecimal refundPrice;
    /**
     * 状态（1.未缴纳，2.部分缴纳，3.全部缴纳）
     */
    private Integer status;
    /**
     * 费率
     */
    private Integer rate;
    /**
     * 缴费期限
     */
    private Date paymentTerm;
    /**
     * 滞纳金
     */
    private BigDecimal overdueFine;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoExpenseBillDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payPeopleName='" + payPeopleName + '\'' +
                ", costPrice=" + costPrice +
                ", paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", paymentPrice=" + paymentPrice +
                ", refundPrice=" + refundPrice +
                ", status=" + status +
                ", rate=" + rate +
                ", paymentTerm=" + paymentTerm +
                ", overdueFine=" + overdueFine +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
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

    public String getPayPeopleName() {
        return payPeopleName;
    }

    public void setPayPeopleName(String payPeopleName) {
        this.payPeopleName = payPeopleName;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(Date paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public BigDecimal getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine(BigDecimal overdueFine) {
        this.overdueFine = overdueFine;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoExpenseBillDetail() {
    }

    public VoExpenseBillDetail(Integer id, String name, String payPeopleName, BigDecimal costPrice, BigDecimal paidPrice, BigDecimal totalPrice, BigDecimal paymentPrice, BigDecimal refundPrice, Integer status, Integer rate, Date paymentTerm, BigDecimal overdueFine, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.payPeopleName = payPeopleName;
        this.costPrice = costPrice;
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
        this.paymentPrice = paymentPrice;
        this.refundPrice = refundPrice;
        this.status = status;
        this.rate = rate;
        this.paymentTerm = paymentTerm;
        this.overdueFine = overdueFine;
        this.createName = createName;
        this.createDate = createDate;
    }
}
