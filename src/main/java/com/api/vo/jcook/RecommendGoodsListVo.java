package com.api.vo.jcook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 推荐商品列表信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendGoodsListVo implements Serializable {
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
    /**
     * 是否收藏(0.不收藏,1.收藏)
     */
    private Integer isCollection;
}
