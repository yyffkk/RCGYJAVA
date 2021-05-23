package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.List;

public class AppMyOrderVo {
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
     * 客户期望：1.退货，2.换货
     */
    private Integer backType;
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
     * 供应商名称
     */
    private String supplierName;
    /**
     * 一级分类名称
     */
    private String levelOneCategory;
    /**
     * 二级分类名称
     */
    private String levelTwoCategory;
    /**
     * 状态：1.待发货，2.已发货，3.已收货，4.申请退换货，5.申请通过，6.申请驳回
     */
    private Integer status;
    /**
     * 到货时间说明
     */
    private String arrivalTime;

    @Override
    public String toString() {
        return "AppMyOrderVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", backType=" + backType +
                ", goodsImgList=" + goodsImgList +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", num=" + num +
                ", supplierName='" + supplierName + '\'' +
                ", levelOneCategory='" + levelOneCategory + '\'' +
                ", levelTwoCategory='" + levelTwoCategory + '\'' +
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

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLevelOneCategory() {
        return levelOneCategory;
    }

    public void setLevelOneCategory(String levelOneCategory) {
        this.levelOneCategory = levelOneCategory;
    }

    public String getLevelTwoCategory() {
        return levelTwoCategory;
    }

    public void setLevelTwoCategory(String levelTwoCategory) {
        this.levelTwoCategory = levelTwoCategory;
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

    public AppMyOrderVo() {
    }

    public AppMyOrderVo(Integer id, String code, Integer goodsId, String goodsName, Integer backType, List<VoResourcesImg> goodsImgList, BigDecimal sellingPrice, BigDecimal markingPrice, Integer num, String supplierName, String levelOneCategory, String levelTwoCategory, Integer status, String arrivalTime) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.backType = backType;
        this.goodsImgList = goodsImgList;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.num = num;
        this.supplierName = supplierName;
        this.levelOneCategory = levelOneCategory;
        this.levelTwoCategory = levelTwoCategory;
        this.status = status;
        this.arrivalTime = arrivalTime;
    }
}
