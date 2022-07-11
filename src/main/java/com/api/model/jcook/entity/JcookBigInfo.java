package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook大图信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookBigInfo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * pc端商品介绍（使用该字段）
     */
    private String pcWdis;
    /**
     * pc js 内容（可能为空）
     */
    private String pcJsContent;
    /**
     * pc css 样式（可能为空）
     */
    private String pcCssContent;
    /**
     * pc html 内容（可能为空）
     */
    private String pcHtmlContent;
}
