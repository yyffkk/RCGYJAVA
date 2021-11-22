package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookCategorySearch;
import com.api.vo.jcook.manageCategory.ManageJcookCategoryVo;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;

import java.util.List;

public interface JcookCategoryService {
    /**
     * 根据分类父类主键id查询分类信息
     * @param manageJcookCategorySearch manage jcook商品分类搜索条件
     * @return map
     */
    List<ManageJcookCategoryVo> listByParentId(ManageJcookCategorySearch manageJcookCategorySearch);
    /**
     * 查询所有的分类信息
     * @return 分类信息
     */
    List<ManageJcookCategoryVo> listAll();
}
