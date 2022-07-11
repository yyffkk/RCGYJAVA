package com.api.vo.jcook.manageGoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * manage jcook商品管理Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookGoodsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * sku编码
     */
    private BigInteger skuId;
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
     * 一级分类名称
     */
    private String categoryFirstName;
    /**
     * 二级分类名称
     */
    private String categorySecondName;
    /**
     * 三级分类名称
     */
    private String categoryThirdName;
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
     * 折扣价
     */
    private BigDecimal discountPrice;
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
     * 浏览量
     */
    private Integer viewsNum;
}
