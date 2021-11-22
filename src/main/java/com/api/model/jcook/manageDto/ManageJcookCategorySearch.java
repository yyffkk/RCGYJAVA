package com.api.model.jcook.manageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * manage jcook商品分类搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookCategorySearch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 父类主键id
     */
    private Integer parentId;
}
