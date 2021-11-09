package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 品牌搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandSearch implements Serializable {
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
     * 关键字
     */
    private String keyword;
}
