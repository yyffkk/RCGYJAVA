package com.api.model.shoppingCenter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * 商品信息
 */
public class Goods {
    /**
     * 商品主键ID
     */
    private Integer id;
    /**
     * 商品编号
     */
    private String code;
    /**
     * 商品分类主键id
     */
    private Integer categoryId;
    /**
     * 商品标题
     */
    private String title;
    /***
     * 推荐语
     */
    private String recommend;
    /**
     * 供应商主键id
     */
    private Integer supplierId;
    /**
     * 商品详情
     */
    private String detail;
    /**
     * 售卖价
     */
    private BigDecimal sellingPrice;
    /**
     * 划线价
     */
    private BigDecimal markingPrice;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 订阅量/预约量
     */
    private Integer subscribeNum;
    /**
     * 提取方式，默认1.线下自提
     */
    private Integer drawType;
    /**
     * 状态 ,1.上架，2.下架
     */
    private Integer status;
    /**
     * 到货时间说明
     */
    private String arrivalTime;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除，1.非删，0.删除
     */
    private Integer isDelete;
    /**
     * 商品照片路径信息
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", recommend='" + recommend + '\'' +
                ", supplierId=" + supplierId +
                ", detail='" + detail + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", stock=" + stock +
                ", subscribeNum=" + subscribeNum +
                ", drawType=" + drawType +
                ", status=" + status +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", imgUrls=" + Arrays.toString(imgUrls) +
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(Integer subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public Integer getDrawType() {
        return drawType;
    }

    public void setDrawType(Integer drawType) {
        this.drawType = drawType;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Goods() {
    }

    public Goods(Integer id, String code, Integer categoryId, String title, String recommend, Integer supplierId, String detail, BigDecimal sellingPrice, BigDecimal markingPrice, Integer stock, Integer subscribeNum, Integer drawType, Integer status, String arrivalTime, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, String[] imgUrls) {
        this.id = id;
        this.code = code;
        this.categoryId = categoryId;
        this.title = title;
        this.recommend = recommend;
        this.supplierId = supplierId;
        this.detail = detail;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.stock = stock;
        this.subscribeNum = subscribeNum;
        this.drawType = drawType;
        this.status = status;
        this.arrivalTime = arrivalTime;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.imgUrls = imgUrls;
    }
}
