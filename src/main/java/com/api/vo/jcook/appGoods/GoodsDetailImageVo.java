package com.api.vo.jcook.appGoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品image列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetailImageVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 图片路由地址
     */
    private String url;
    /**
     * 是否主图，0.否，1.是
     */
    private Integer isPrimer;
    /**
     * 图片排序
     */
    private Integer orderSort;
}
