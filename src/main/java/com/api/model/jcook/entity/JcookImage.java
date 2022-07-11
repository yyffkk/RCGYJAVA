package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook商品图片表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookImage {
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
