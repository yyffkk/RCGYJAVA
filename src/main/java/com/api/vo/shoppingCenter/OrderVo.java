package com.api.vo.shoppingCenter;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单管理 Vo list 回显
 */
public class OrderVo {
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
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品照片
     */
    private List<VoResourcesImg> goodsImgList;
    /**
     * 售卖价
     */
    private BigDecimal sellingPrice;
    /**
     * 划线价
     */
    private BigDecimal markingPrice;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 用户房屋名称
     */
    private String roomName;
    /**
     * 状态：1.待发货，2.已发货，3.已到货，4.已收货，6.已评价，8.申请退换货，9.申请通过，10.申请驳回
     */
    private Integer status;
    /**
     * 到货时间说明
     */
    private String arrivalTime;

    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImgList=" + goodsImgList +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", num=" + num +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", arrivalTime='" + arrivalTime + '\'' +
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<VoResourcesImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<VoResourcesImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getMarkingPrice() {
        return markingPrice;
    }

    public void setMarkingPrice(BigDecimal markingPrice) {
        this.markingPrice = markingPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public OrderVo() {
    }

    public OrderVo(Integer id, String code, Integer goodsId, String goodsName, List<VoResourcesImg> goodsImgList, BigDecimal sellingPrice, BigDecimal markingPrice, Integer num, String userName, String userTel, String roomName, Integer status, String arrivalTime) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImgList = goodsImgList;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.num = num;
        this.userName = userName;
        this.userTel = userTel;
        this.roomName = roomName;
        this.status = status;
        this.arrivalTime = arrivalTime;
    }
}
