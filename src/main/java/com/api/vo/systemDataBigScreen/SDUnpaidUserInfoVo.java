package com.api.vo.systemDataBigScreen;

import java.math.BigDecimal;

/**
 * 系统数据 未缴费用户信息Vo list 回显
 */
public class SDUnpaidUserInfoVo {
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 待缴金额
     */
    private BigDecimal paymentPrice;
    /**
     * 费用类型名称
     */
    private String chargesTemplateDetailName;

    @Override
    public String toString() {
        return "SDUnpaidUserInfoVo{" +
                "roomName='" + roomName + '\'' +
                ", paymentPrice=" + paymentPrice +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                '}';
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }

    public SDUnpaidUserInfoVo() {
    }

    public SDUnpaidUserInfoVo(String roomName, BigDecimal paymentPrice, String chargesTemplateDetailName) {
        this.roomName = roomName;
        this.paymentPrice = paymentPrice;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }
}
