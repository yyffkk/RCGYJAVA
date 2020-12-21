package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 日常缴费 信息model
 */
public class DailyPayment {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 计费开始时间
     */
    private Date beginDate;
    /**
     * 计费结束时间
     */
    private Date endDate;
    /**
     * 计费单价
     */
    private BigDecimal unitPrice;
    /**
     * 计费单位
     */
    private Integer type;
    /**
     * 面积/用量/数量
     */
    private Integer num;
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
     * 状态（1.未缴纳，2.部分缴纳，3.全部缴纳）
     */
    private Integer status;
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
    /**
     * 日常缴费订单信息
     */
    private DailyPaymentOrder dailyPaymentOrder;

    @Override
    public String toString() {
        return "DailyPayment{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", num=" + num +
                ", costPrice=" + costPrice +
                ", paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", paymentPrice=" + paymentPrice +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", dailyPaymentOrder=" + dailyPaymentOrder +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public DailyPaymentOrder getDailyPaymentOrder() {
        return dailyPaymentOrder;
    }

    public void setDailyPaymentOrder(DailyPaymentOrder dailyPaymentOrder) {
        this.dailyPaymentOrder = dailyPaymentOrder;
    }

    public DailyPayment() {
    }

    public DailyPayment(Integer id, Integer buildingUnitEstateId, Integer chargesTemplateDetailId, Date beginDate, Date endDate, BigDecimal unitPrice, Integer type, Integer num, BigDecimal costPrice, BigDecimal paidPrice, BigDecimal totalPrice, BigDecimal paymentPrice, Integer status, Integer createId, Date createDate, Integer modifyId, Date modifyDate, DailyPaymentOrder dailyPaymentOrder) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.unitPrice = unitPrice;
        this.type = type;
        this.num = num;
        this.costPrice = costPrice;
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
        this.paymentPrice = paymentPrice;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.dailyPaymentOrder = dailyPaymentOrder;
    }
}
