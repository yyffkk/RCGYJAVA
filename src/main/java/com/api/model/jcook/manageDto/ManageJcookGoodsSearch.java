package com.api.model.jcook.manageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * manage jcook商品搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookGoodsSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * sku编码
     */
    private BigInteger skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 供应商名称
     */
    private String vendorName;
    /**
     * jcook商品上架状态，0.下架，1.上架(当该状态下架，商品直接下架，不考虑小蜜蜂商品状态)
     */
    private Integer status;
    /**
     * 小蜜蜂商品上架状态，0.下架，1.上架（当jcook商品状态为上架才生效）
     */
    private Integer shopStatus;

}
