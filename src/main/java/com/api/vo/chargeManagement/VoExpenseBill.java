package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用账单（账单管理）Vo list 回显
 */
public class VoExpenseBill {
    /**
     * 房屋主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 费用总计
     */
    private BigDecimal costPriceSum;
    /**
     * 退款总计
     */
    private BigDecimal refundPriceSum;
    /**
     * 应收金额总计（费用总计+滞纳金总计）
     */
    private BigDecimal totalPriceSum;
    /**
     * 实收费用总计（包含状态为完全缴纳状态的滞纳金）
     */
    private BigDecimal paidPriceSum;
    /**
     * 剩余未缴总计（包含状态为未缴纳或部分缴纳状态的滞纳金）
     */
    private BigDecimal paymentPriceSum;

    @Override
    public String toString() {
        return "VoExpenseBill{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", costPriceSum=" + costPriceSum +
                ", refundPriceSum=" + refundPriceSum +
                ", totalPriceSum=" + totalPriceSum +
                ", paidPriceSum=" + paidPriceSum +
                ", paymentPriceSum=" + paymentPriceSum +
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

    public BigDecimal getCostPriceSum() {
        return costPriceSum;
    }

    public void setCostPriceSum(BigDecimal costPriceSum) {
        this.costPriceSum = costPriceSum;
    }

    public BigDecimal getRefundPriceSum() {
        return refundPriceSum;
    }

    public void setRefundPriceSum(BigDecimal refundPriceSum) {
        this.refundPriceSum = refundPriceSum;
    }

    public BigDecimal getTotalPriceSum() {
        return totalPriceSum;
    }

    public void setTotalPriceSum(BigDecimal totalPriceSum) {
        this.totalPriceSum = totalPriceSum;
    }

    public BigDecimal getPaidPriceSum() {
        return paidPriceSum;
    }

    public void setPaidPriceSum(BigDecimal paidPriceSum) {
        this.paidPriceSum = paidPriceSum;
    }

    public BigDecimal getPaymentPriceSum() {
        return paymentPriceSum;
    }

    public void setPaymentPriceSum(BigDecimal paymentPriceSum) {
        this.paymentPriceSum = paymentPriceSum;
    }

    public VoExpenseBill() {
    }

    public VoExpenseBill(Integer id, String roomName, BigDecimal costPriceSum, BigDecimal refundPriceSum, BigDecimal totalPriceSum, BigDecimal paidPriceSum, BigDecimal paymentPriceSum) {
        this.id = id;
        this.roomName = roomName;
        this.costPriceSum = costPriceSum;
        this.refundPriceSum = refundPriceSum;
        this.totalPriceSum = totalPriceSum;
        this.paidPriceSum = paidPriceSum;
        this.paymentPriceSum = paymentPriceSum;
    }
}
