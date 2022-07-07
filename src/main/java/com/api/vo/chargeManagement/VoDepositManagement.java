package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 押金管理Vo list 回显
 */
public class VoDepositManagement {
    /**
     * 押金管理主键id
     */
    private Integer id;
    /**
     * 装修主键id
     */
    private Integer decorationId;
    /**
     * 费用名称
     */
    private String chargesTemplateDetailName;
    /**
     * 交易号（退款单 退款单号）
     */
    private String orderCode;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 押金人
     */
    private String depositName;
    /**
     * 押金人联系方式
     */
    private String tel;
    /**
     * 缴费时间
     */
    private Date payDate;
    /**
     * 押金金额
     */
    private BigDecimal depositPrice;
    /**
     * 状态 1.未退，2.已退
     */
    private Integer status;
    /**
     * 来源：1.app，2.线下
     */
    private Integer froms;
    /**
     * 支付方式：1.app支付宝，2.app微信，3.现金，4.线下支付宝，5.线下微信
     */
    private Integer payType;
    /**
     * 装修开始时间
     */
    private Date renovationDateStart;
    /**
     * 装修结束时间
     */
    private Date renovationDateEnd;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建人
     */
    private String createName;

    @Override
    public String toString() {
        return "VoDepositManagement{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", roomName='" + roomName + '\'' +
                ", depositName='" + depositName + '\'' +
                ", tel='" + tel + '\'' +
                ", payDate=" + payDate +
                ", depositPrice=" + depositPrice +
                ", status=" + status +
                ", froms=" + froms +
                ", payType=" + payType +
                ", renovationDateStart=" + renovationDateStart +
                ", renovationDateEnd=" + renovationDateEnd +
                ", remake='" + remake + '\'' +
                ", createName='" + createName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
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

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getRenovationDateStart() {
        return renovationDateStart;
    }

    public void setRenovationDateStart(Date renovationDateStart) {
        this.renovationDateStart = renovationDateStart;
    }

    public Date getRenovationDateEnd() {
        return renovationDateEnd;
    }

    public void setRenovationDateEnd(Date renovationDateEnd) {
        this.renovationDateEnd = renovationDateEnd;
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

    public VoDepositManagement() {
    }

    public VoDepositManagement(Integer id, Integer decorationId, String chargesTemplateDetailName, String orderCode, String roomName, String depositName, String tel, Date payDate, BigDecimal depositPrice, Integer status, Integer froms, Integer payType, Date renovationDateStart, Date renovationDateEnd, String remake, String createName) {
        this.id = id;
        this.decorationId = decorationId;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
        this.orderCode = orderCode;
        this.roomName = roomName;
        this.depositName = depositName;
        this.tel = tel;
        this.payDate = payDate;
        this.depositPrice = depositPrice;
        this.status = status;
        this.froms = froms;
        this.payType = payType;
        this.renovationDateStart = renovationDateStart;
        this.renovationDateEnd = renovationDateEnd;
        this.remake = remake;
        this.createName = createName;
    }
}
