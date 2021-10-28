package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook主体规格参数详情
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookSpecificationAttribute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 规格参数主体主键id
     */
    private Integer jcookSpecificationId;
    /**
     * 键
     */
    private String name;
    /**
     * 值
     */
    private String values;
}
