package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * jcook商品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookGoods {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * sku编码
     */
    private Integer skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 一级分类主键id
     */
    private Integer categoryFirstId;
    /**
     * 二级分类主键id
     */
    private Integer categorySecondId;
    /**
     * 三级分类主键id
     */
    private Integer categoryThirdId;
    /**
     * 主图url
     */
    private String mainPhoto;
    /**
     * 上架状态，1.上架，2.下架
     */
    private Integer status;
    /**
     * 供货价
     */
    private BigDecimal supplyPrice;
    /**
     * 指导价
     */
    private BigDecimal guidePrice;
    /**
     * 售卖价
     */
    private BigDecimal sellPrice;
    /**
     * 是否有效商品可能因为 长时间无效置为无效
     */
    private Integer yn;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
}
