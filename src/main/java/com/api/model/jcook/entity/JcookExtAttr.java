package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook额外规格参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookExtAttr {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 键
     */
    private String name;
    /**
     * 值
     */
    private String value;
}
