package com.api.vo.jcook.appGoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品详情回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetailVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * image列表
     */
    private List<GoodsDetailImageVo> goodsDetailImageVos;
    /**
     * 售卖价格
     */
    private BigDecimal sellPrice;
    /**
     * 折扣价格
     */
    private BigDecimal discountPrice;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 售卖量
     */
    private Integer sellNum;
    /**
     *  0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
    /**
     * 默认所在地区
     */
    private String defaultLocation;
    /**
     * 默认详细地址
     */
    private String defaultAddressDetail;
    /**
     * 库存状态(1.有货，0.无货)
     */
    private Integer stockStatus;
    /**
     * 参数（品牌、规格）
     */
    private List<GoodsDetailSpecificationVo> goodsDetailSpecificationVoList;

}
