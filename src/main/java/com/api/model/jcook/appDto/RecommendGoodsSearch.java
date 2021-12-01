package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 推荐商品搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendGoodsSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 销量排序(1.desc[降序]，2.asc[升序])
     */
    private Integer orderBySalesVolume;
    /**
     * 价格排序(1.desc[降序]，2.asc[升序])
     */
    private Integer orderByPrice;
    /**
     * 关键字搜索
     */
    private String keyword;
    /**
     * 品牌主键id
     */
    private Integer brandId;
    /**
     * 三级分类主键id
     */
    private Integer categoryThirdId;
    /**
     * 最小价格
     */
    private BigDecimal minPrice;
    /**
     * 最大价格
     */
    private BigDecimal maxPrice;
}
