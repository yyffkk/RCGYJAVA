package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * jcook全部显示分类信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookCategoryAllShow implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * jcook可显示的子分类集合
     */
    private List<JcookCategoryAllShow> categoryList;
}
