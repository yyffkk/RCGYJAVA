package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.Category;
import com.api.vo.shoppingCenter.CategoryVo;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有的类目信息
     * @param parentId 父类id，如果为一级则为0
     * @return 类目信息集合
     */
    List<CategoryVo> list(Integer parentId);

    /**
     * 添加类目信息
     * @param category 商品分类表
     * @return 影响行数
     */
    int insert(Category category);

    /**
     * 修改类目信息
     * @param category 商品分类表
     * @return 影响行数
     */
    int update(Category category);

    /**
     * 删除类目信息
     * @param categoryId 类目主键Id
     * @return 影响行数
     */
    int delete(Integer categoryId);

    /**
     * 删除子类目信息
     * @param categoryId 类目主键Id
     * @return 影响行数
     */
    int deleteSon(Integer categoryId);
}
