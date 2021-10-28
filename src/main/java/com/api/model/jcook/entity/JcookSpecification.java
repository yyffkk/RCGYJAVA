package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook主体规格参数组
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookSpecification {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 组名
     */
    private String groupName;
}
