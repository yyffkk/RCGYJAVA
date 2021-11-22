package com.api.vo.jcook.manageCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * manage jcook商品分类管理Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookCategoryVo implements Serializable {
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
     * 是否显示，1.显示，2.隐藏，隐藏上级会使下级分类一起隐藏
     */
    private Integer isShow;
    /**
     * manage jcook商品子分类信息集合
     */
    private List<ManageJcookCategoryVo> manageJcookCategoryVoList;
}
