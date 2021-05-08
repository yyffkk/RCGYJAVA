package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.List;

/**
 * app商品详情Vo 回显
 */
public class AppGoodsDetailVo {
    /**
     * 商品主键id
     */
    private Integer id;
    /**
     * 推荐语
     */
    private String recommend;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 售卖价
     */
    private BigDecimal sellingPrice;
    /**
     * 划线价
     */
    private BigDecimal markingPrice;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 订阅量
     */
    private Integer subscribeNum;
    /**
     * 商品详情
     */
    private String detail;
    /**
     * 到货时间说明
     */
    private String arrivalTime;
    /**
     * 商品照片信息
     */
    private List<VoResourcesImg> goodsImgList;
    /**
     * 供应商主键id
     */
    private Integer supplierId;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 供应商手机号
     */
    private String supplierTel;
    /**
     * 供应商地址
     */
    private String supplierAddress;
    /**
     * 供应商照片信息
     */
    private List<VoResourcesImg> supplierImgList;
    /**
     * 当前用户是否订阅，1.订阅，0.没订阅
     */
    private Integer isSubscribe;

    @Override
    public String toString() {
        return "AppGoodsDetailVo{" +
                "id=" + id +
                ", recommend='" + recommend + '\'' +
                ", title='" + title + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", categoryName='" + categoryName + '\'' +
                ", subscribeNum=" + subscribeNum +
                ", detail='" + detail + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", goodsImgList=" + goodsImgList +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierTel='" + supplierTel + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierImgList=" + supplierImgList +
                ", isSubscribe=" + isSubscribe +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(Integer subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<VoResourcesImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<VoResourcesImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public List<VoResourcesImg> getSupplierImgList() {
        return supplierImgList;
    }

    public void setSupplierImgList(List<VoResourcesImg> supplierImgList) {
        this.supplierImgList = supplierImgList;
    }

    public Integer getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Integer isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public AppGoodsDetailVo() {
    }

    public AppGoodsDetailVo(Integer id, String recommend, String title, BigDecimal sellingPrice, BigDecimal markingPrice, String categoryName, Integer subscribeNum, String detail, String arrivalTime, List<VoResourcesImg> goodsImgList, Integer supplierId, String supplierName, String supplierTel, String supplierAddress, List<VoResourcesImg> supplierImgList, Integer isSubscribe) {
        this.id = id;
        this.recommend = recommend;
        this.title = title;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.categoryName = categoryName;
        this.subscribeNum = subscribeNum;
        this.detail = detail;
        this.arrivalTime = arrivalTime;
        this.goodsImgList = goodsImgList;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierTel = supplierTel;
        this.supplierAddress = supplierAddress;
        this.supplierImgList = supplierImgList;
        this.isSubscribe = isSubscribe;
    }
}
