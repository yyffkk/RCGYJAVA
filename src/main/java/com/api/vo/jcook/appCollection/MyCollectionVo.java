package com.api.vo.jcook.appCollection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 我的收藏夹 Vo 回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCollectionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品主键id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 主图url
     */
    private String mainPhoto;
    /**
     * jcook商品上架状态，0.下架，1.上架(当该状态下架，商品直接下架，不考虑小蜜蜂商品状态)
     */
    private Integer status;
    /**
     * 小蜜蜂商品上架状态，0.下架，1.上架（当jcook商品状态为上架才生效）
     */
    private Integer shopStatus;
    /**
     * 售卖价
     */
    private BigDecimal sellPrice;
    /**
     * 折扣价
     */
    private BigDecimal discountPrice;
    /**
     *  0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
}
