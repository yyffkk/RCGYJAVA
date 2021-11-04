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
     * 商铺名称
     */
    private String shopName;
    /**
     * 供应商名称
     */
    private String vendorName;
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
     * jcook上架状态，1.上架，0.下架
     */
    private Integer status;
    /**
     * 小蜜蜂商品上架状态，1.上架，0.下架
     */
    private Integer shopStatus;
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
     * 型号
     */
    private String model;
    /**
     * 税率
     */
    private String tax;
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
     * 颜色
     */
    private String color;
    /**
     * 质保
     */
    private String warranty;
    /**
     * 质保天数
     */
    private String shelfLife;
    /**
     * 发货地址
     */
    private String delivery;
    /**
     * 产地
     */
    private String placeOfProduction;
    /**
     * 0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
    /**
     * 长（毫米）
     */
    private Integer length;
    /**
     * 宽（毫米）
     */
    private Integer width;
    /**
     * 高（毫米）
     */
    private Integer height;
    /**
     * 重量（千克）
     */
    private Integer weight;
}
