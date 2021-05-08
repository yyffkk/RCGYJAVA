package com.api.app.dao.shoppingCenter;

import com.api.vo.app.AppCategoryVo;

import java.util.List;

public interface ShoppingDao {
    List<AppCategoryVo> list(Integer parentId);
}
