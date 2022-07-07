package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单费用Vo list 回显
 */
public class VoWorkOrderCost {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 费用单号（工单表中的工单号）
     */
    private String dispatchListCode;
    /**
     * 工单主键id
     */
    private Integer dispatchListId;
    /**
     * 交易号（缴费订单表的支付单号）
     */
    private String orderCode;
    /**
     * 房屋信息
     */
    private String roomName;
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
     * 计费单位(数据字典取)
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
     * 备注（订单中的备注信息）
     */
    private String remake;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 更新时间
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "VoWorkOrderCost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dispatchListCode='" + dispatchListCode + '\'' +
                ", dispatchListId=" + dispatchListId +
                ", orderCode='" + orderCode + '\'' +
                ", roomName='" + roomName + '\'' +
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
                ", remake='" + remake + '\'' +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
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

    public String getDispatchListCode() {
        return dispatchListCode;
    }

    public void setDispatchListCode(String dispatchListCode) {
        this.dispatchListCode = dispatchListCode;
    }

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public VoWorkOrderCost() {
    }

    public VoWorkOrderCost(Integer id, String name, String dispatchListCode, Integer dispatchListId, String orderCode, String roomName, Date beginDate, Date endDate, BigDecimal unitPrice, Integer type, Integer num, BigDecimal costPrice, BigDecimal paidPrice, BigDecimal totalPrice, BigDecimal paymentPrice, Integer status, String remake, String createName, Date updateDate) {
        this.id = id;
        this.name = name;
        this.dispatchListCode = dispatchListCode;
        this.dispatchListId = dispatchListId;
        this.orderCode = orderCode;
        this.roomName = roomName;
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
        this.remake = remake;
        this.createName = createName;
        this.updateDate = updateDate;
    }
}
