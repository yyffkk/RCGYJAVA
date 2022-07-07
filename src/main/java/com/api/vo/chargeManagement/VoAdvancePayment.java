package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预缴信息 Vo 回显
 */
public class VoAdvancePayment {
    /**
     * 房产主键Id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 住户姓名
     */
    private String residentName;
    /**
     * 预缴余额
     */
    private BigDecimal advancePaymentPrice;
    /**
     * 最近充值时间
     */
    private Date nearDate;

    @Override
    public String toString() {
        return "VoAdvancePayment{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", advancePaymentPrice=" + advancePaymentPrice +
                ", nearDate=" + nearDate +
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public BigDecimal getAdvancePaymentPrice() {
        return advancePaymentPrice;
    }

    public void setAdvancePaymentPrice(BigDecimal advancePaymentPrice) {
        this.advancePaymentPrice = advancePaymentPrice;
    }

    public Date getNearDate() {
        return nearDate;
    }

    public void setNearDate(Date nearDate) {
        this.nearDate = nearDate;
    }

    public VoAdvancePayment() {
    }

    public VoAdvancePayment(Integer id, String roomName, String residentName, BigDecimal advancePaymentPrice, Date nearDate) {
        this.id = id;
        this.roomName = roomName;
        this.residentName = residentName;
        this.advancePaymentPrice = advancePaymentPrice;
        this.nearDate = nearDate;
    }
}
