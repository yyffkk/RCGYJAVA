package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app 生活缴费详情Vo list 回显
 */
public class AppDailyPaymentDetailsVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 账单月份
     */
    private String month;
    /**
     * 账单金额
     */
    private BigDecimal costPrice;
    /**
     * 已缴金额
     */
    private BigDecimal paidPrice;
    /**
     * 本次应收总计
     */
    private BigDecimal totalPrice;
    /**
     * 计费开始时间
     */
    private Date beginDate;
    /**
     * 计费结束时间
     */
    private Date endDate;
    /**
     * 单位价格（计费单价+计费单位）
     */
    private String unitPriceType;
    /**
     * 面积/用量/数量
     */
    private Integer num;
    /**
     * 待缴金额
     */
    private BigDecimal paymentPrice;
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

    @Override
    public String toString() {
        return "AppDailyPaymentDetailsVo{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", costPrice=" + costPrice +
                ", paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", unitPriceType='" + unitPriceType + '\'' +
                ", num=" + num +
                ", paymentPrice=" + paymentPrice +
                ", status=" + status +
                ", rate=" + rate +
                ", paymentTerm=" + paymentTerm +
                ", overdueFine=" + overdueFine +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUnitPriceType() {
        return unitPriceType;
    }

    public void setUnitPriceType(String unitPriceType) {
        this.unitPriceType = unitPriceType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
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

    public AppDailyPaymentDetailsVo() {
    }

    public AppDailyPaymentDetailsVo(Integer id, String month, BigDecimal costPrice, BigDecimal paidPrice, BigDecimal totalPrice, Date beginDate, Date endDate, String unitPriceType, Integer num, BigDecimal paymentPrice, Integer status, Integer rate, Date paymentTerm, BigDecimal overdueFine) {
        this.id = id;
        this.month = month;
        this.costPrice = costPrice;
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.unitPriceType = unitPriceType;
        this.num = num;
        this.paymentPrice = paymentPrice;
        this.status = status;
        this.rate = rate;
        this.paymentTerm = paymentTerm;
        this.overdueFine = overdueFine;
    }
}
