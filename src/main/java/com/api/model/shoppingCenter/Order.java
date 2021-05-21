package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 商品预约model（订单）
 */
public class Order {
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
     * 状态：1.待发货，2.已发货，3.已收货
     */
    private Integer status;
    /**
     * 发货时间
     */
    private Date sendDate;
    /**
     * 发货信息
     */
    private String sendDetail;
    /**
     * 发货操作人
     */
    private Integer sendOperator;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 商品数量
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", status=" + status +
                ", sendDate=" + sendDate +
                ", sendDetail='" + sendDetail + '\'' +
                ", sendOperator=" + sendOperator +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", num=" + num +
                ", createId=" + createId +
                ", createDate=" + createDate +
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendDetail() {
        return sendDetail;
    }

    public void setSendDetail(String sendDetail) {
        this.sendDetail = sendDetail;
    }

    public Integer getSendOperator() {
        return sendOperator;
    }

    public void setSendOperator(Integer sendOperator) {
        this.sendOperator = sendOperator;
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

    public Order() {
    }

    public Order(Integer id, String code, Integer goodsId, Integer status, Date sendDate, String sendDetail, Integer sendOperator, String userName, String userTel, Integer num, Integer createId, Date createDate) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.status = status;
        this.sendDate = sendDate;
        this.sendDetail = sendDetail;
        this.sendOperator = sendOperator;
        this.userName = userName;
        this.userTel = userTel;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
    }
}
