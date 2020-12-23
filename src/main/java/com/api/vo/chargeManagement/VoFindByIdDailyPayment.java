package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 日常缴纳表Vo findById 回显
 */
public class VoFindByIdDailyPayment {
    /**
     * 日常缴纳主键id
     */
    private Integer id;
    /**
     * 房间信息
     */
    private String roomName;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 收费总计
     */
    private BigDecimal totalPrice;
    /**
     * 费用名称
     */
    private String chargesTemplateDetailName;
    /**
     * 费用类型名称（1.物业管理费，2.维修费（报事报修 唯一））
     */
    private Integer workOrderType;
    /**
     * 计费开始时间
     */
    private Date beginDate;
    /**
     * 计费结束时间
     */
    private Date endDate;
    /**
     * 费用金额
     */
    private BigDecimal costPrice;
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
     * 已缴金额
     */
    private BigDecimal paidPrice;
    /**
     * 待缴金额
     */
    private BigDecimal paymentPrice;

    @Override
    public String toString() {
        return "VoFindByIdDailyPayment{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                ", workOrderType=" + workOrderType +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", costPrice=" + costPrice +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", num=" + num +
                ", paidPrice=" + paidPrice +
                ", paymentPrice=" + paymentPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }

    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
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

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public VoFindByIdDailyPayment() {
    }

    public VoFindByIdDailyPayment(Integer id, String roomName, String customerName, BigDecimal totalPrice, String chargesTemplateDetailName, Integer workOrderType, Date beginDate, Date endDate, BigDecimal costPrice, BigDecimal unitPrice, Integer type, Integer num, BigDecimal paidPrice, BigDecimal paymentPrice) {
        this.id = id;
        this.roomName = roomName;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
        this.workOrderType = workOrderType;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.costPrice = costPrice;
        this.unitPrice = unitPrice;
        this.type = type;
        this.num = num;
        this.paidPrice = paidPrice;
        this.paymentPrice = paymentPrice;
    }
}
