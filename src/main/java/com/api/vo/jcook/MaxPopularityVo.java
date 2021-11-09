package com.api.vo.jcook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 最大人气商品回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaxPopularityVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 主图url
     */
    private String mainPhoto;
    /**
     * 浏览量
     */
    private Integer viewsNum;
}
