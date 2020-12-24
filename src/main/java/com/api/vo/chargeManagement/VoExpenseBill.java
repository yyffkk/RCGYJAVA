package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用账单（账单管理）Vo list 回显
 */
public class VoExpenseBill {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用项目
     */
    private String name;
    /**
     * 交易号（缴费订单表的支付单号）
     */
    private String orderCode;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 缴费时间
     */
    private String payDate;
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
     * 应收总计
     */
    private BigDecimal totalPrice;
    /**
     * 状态（1.未缴纳，2.部分缴纳，3.全部缴纳）
     */
    private Integer status;
    /**
     * 缴费人姓名
     */
    private String payName;
    /**
     * 缴费人联系方式
     */
    private String payTel;
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
        return "VoExpenseBill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", roomName='" + roomName + '\'' +
                ", payDate='" + payDate + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", costPrice=" + costPrice +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", payName='" + payName + '\'' +
                ", payTel='" + payTel + '\'' +
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

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayTel() {
        return payTel;
    }

    public void setPayTel(String payTel) {
        this.payTel = payTel;
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

    public VoExpenseBill() {
    }

    public VoExpenseBill(Integer id, String name, String orderCode, String roomName, String payDate, Date beginDate, Date endDate, BigDecimal costPrice, BigDecimal totalPrice, Integer status, String payName, String payTel, String remake, String createName, Date updateDate) {
        this.id = id;
        this.name = name;
        this.orderCode = orderCode;
        this.roomName = roomName;
        this.payDate = payDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.costPrice = costPrice;
        this.totalPrice = totalPrice;
        this.status = status;
        this.payName = payName;
        this.payTel = payTel;
        this.remake = remake;
        this.createName = createName;
        this.updateDate = updateDate;
    }
}
