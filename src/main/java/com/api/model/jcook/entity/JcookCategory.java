package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jcook分类表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookCategory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 上级主键id，顶层为0
     */
    private Integer parentId;
    /**
     * 是否显示，1.显示，2.隐藏，隐藏上级会使下级分类一起隐藏
     */
    private Integer isShow;
}
