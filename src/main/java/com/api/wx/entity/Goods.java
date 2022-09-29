package com.api.wx.entity;


import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2018-08-23
 **/
@Data
public class Goods {
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 分类id
     */
    private Long categoryId;


    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格 单位分
     */
    private Long goodsPrice;

    /**
     * 商品条码
     */
    private String goodsBarcode;

    /**
     * 商品库存
     */
    private Integer goodsInventory;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 图片url
     */
    private String goodsPicture;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private boolean deleted;

}