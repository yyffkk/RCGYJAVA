package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.Category;

import java.util.Map;

public interface CategoryService {
    Map<String, Object> list(Integer parentId);

    Map<String, Object> insert(Category category);

    Map<String, Object> update(Category category);

    Map<String, Object> delete(Integer categoryId);
}
