package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 缴费记录Vo list 回显
 */
public class AppPaymentRecordVo {
    /**
     * 缴费主键id（缴费表）
     */
    private Integer id;
    /**
     * 收费类型名称
     */
    private String chargesTemplateDetailName;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 年份
     */
    private String years;
    /**
     * 已缴金额
     */
    private BigDecimal paidPrice;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 付款方式（1.支付宝，2.微信，3.现金，3.pos）
     */
    private Integer payType;
    /**
     * 支付单号
     */
    private String code;

    @Override
    public String toString() {
        return "AppPaymentRecordVo{" +
                "id=" + id +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", years='" + years + '\'' +
                ", paidPrice=" + paidPrice +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", payType=" + payType +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AppPaymentRecordVo() {
    }

    public AppPaymentRecordVo(Integer id, String chargesTemplateDetailName, String roomName, String years, BigDecimal paidPrice, String createName, Date createDate, Integer payType, String code) {
        this.id = id;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
        this.roomName = roomName;
        this.years = years;
        this.paidPrice = paidPrice;
        this.createName = createName;
        this.createDate = createDate;
        this.payType = payType;
        this.code = code;
    }
}
