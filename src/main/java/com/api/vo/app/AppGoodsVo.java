package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.List;

/**
 * app 商品信息Vo list 回显
 */
public class AppGoodsVo {
    /**
     * 商品主键id
     */
    private Integer id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 推荐语
     */
    private String recommend;
    /**
     * 售卖价
     */
    private BigDecimal sellingPrice;
    /**
     * 划线价
     */
    private BigDecimal markingPrice;
    /**
     * 订阅量
     */
    private Integer subscribeNum;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "AppGoodsVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", recommend='" + recommend + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", subscribeNum=" + subscribeNum +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(Integer subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public AppGoodsVo() {
    }

    public AppGoodsVo(Integer id, String title, String recommend, BigDecimal sellingPrice, BigDecimal markingPrice, Integer subscribeNum, List<VoResourcesImg> imgList) {
        this.id = id;
        this.title = title;
        this.recommend = recommend;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.subscribeNum = subscribeNum;
        this.imgList = imgList;
    }
}
