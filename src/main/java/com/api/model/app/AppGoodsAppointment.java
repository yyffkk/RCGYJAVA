package com.api.model.app;

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
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 状态：1.待发货，2.已发货，3.已收货
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

    @Override
    public String toString() {
        return "AppGoodsAppointment{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", status=" + status +
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

    public AppGoodsAppointment() {
    }

    public AppGoodsAppointment(Integer id, Integer goodsId, Integer status, String userName, String userTel, Integer num, Integer createId, Date createDate) {
        this.id = id;
        this.goodsId = goodsId;
        this.status = status;
        this.userName = userName;
        this.userTel = userTel;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
    }
}
