package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookCategorySearch;
import com.api.vo.jcook.manageCategory.ManageJcookCategoryVo;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;

import java.util.List;
import java.util.Map;

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
    /**
     * 显示当前分类
     * @param jcookCategoryId 分类主键id
     * @return map
     */
    Map<String, Object> show(Integer jcookCategoryId);
    /**
     * 隐藏当前分类
     * @param jcookCategoryId 分类主键id
     * @return map
     */
    Map<String, Object> hide(Integer jcookCategoryId);

}
