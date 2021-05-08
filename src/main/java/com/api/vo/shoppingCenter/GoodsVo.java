package com.api.vo.shoppingCenter;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品信息 Vo list 回显
 */
public class GoodsVo {
    /**
     * 商品主键id
     */
    private Integer id;
    /**
     * 商品编号
     */
    private String code;
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
     * 总库存
     */
    private Integer stock;
    /**
     * 订阅量/预约量
     */
    private Integer subscribeNum;
    /**
     * 状态，1.上架，2.下架
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "GoodsVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", stock=" + stock +
                ", subscribeNum=" + subscribeNum +
                ", status=" + status +
                ", createDate=" + createDate +
                ", imgList=" + imgList +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public GoodsVo() {
    }

    public GoodsVo(Integer id, String code, String title, BigDecimal sellingPrice, BigDecimal markingPrice, Integer stock, Integer subscribeNum, Integer status, Date createDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.stock = stock;
        this.subscribeNum = subscribeNum;
        this.status = status;
        this.createDate = createDate;
        this.imgList = imgList;
    }
}
