package com.api.model.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app 商品预约信息
 */
public class AppGoodsAppointment {
    /**
     * 商品预约主键id
     */
    private Integer id;
    /**
     * 商品预约编号
     */
    private String code;
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 状态：-2.交易创建并等待买家付款，-1.未付款交易超时关闭或支付完成后全额退款，1.待发货（交易支付成功），2.已发货，3.已到货，4.已收货，6.已评价[当状态>=4.已收货并评价]，8.申请退换货，9.申请通过，10.申请驳回
     */
    private Integer status;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 商品数量（无数量则填1）
     */
    private Integer num;
    /**
     * 创建人 用户主键id【住户表】
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 商品单价
     */
    private Integer unitPrice;
    /**
     * 付款方式（1.支付宝，2.微信，3.现金，3.pos）
     */
    private Integer payType;
    /**
     * 付款金额
     */
    private BigDecimal payPrice;
    /**
     * 是否库存回库，0.未回库，1.已回库
     */
    private Integer backLibrary;

    @Override
    public String toString() {
        return "AppGoodsAppointment{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", num=" + num +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", unitPrice=" + unitPrice +
                ", payType=" + payType +
                ", payPrice=" + payPrice +
                ", backLibrary=" + backLibrary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getBackLibrary() {
        return backLibrary;
    }

    public void setBackLibrary(Integer backLibrary) {
        this.backLibrary = backLibrary;
    }

    public AppGoodsAppointment() {
    }

    public AppGoodsAppointment(Integer id, String code, Integer goodsId, Integer status, String userName, String userTel, Integer num, Integer createId, Date createDate, Integer unitPrice, Integer payType, BigDecimal payPrice, Integer backLibrary) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.status = status;
        this.userName = userName;
        this.userTel = userTel;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
        this.unitPrice = unitPrice;
        this.payType = payType;
        this.payPrice = payPrice;
        this.backLibrary = backLibrary;
    }
}
