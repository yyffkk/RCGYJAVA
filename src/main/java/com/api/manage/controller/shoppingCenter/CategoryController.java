package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.CategoryService;
import com.api.manage.shiro.ShiroExceptions;
import com.api.model.shoppingCenter.Category;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 分类管理
 */
@RestController
@RequestMapping("manage/shop/category")
public class CategoryController extends ShiroExceptions {
    @Resource
    CategoryService categoryService;

    /**
     * 查询所有的类目信息
     * @param parentId 父类id，如果为一级则为0
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer parentId){
        return categoryService.list(parentId);
    }

    /**
     * 添加类目信息
     * @param category 商品分类表
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Category category){
        return categoryService.insert(category);
    }

    /**
     * 修改类目信息
     * @param category 商品分类表
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody Category category){
        return categoryService.update(category);
    }

    /**
     * 删除类目信息
     * @param categoryId 类目主键id
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer categoryId){
        return categoryService.delete(categoryId);
    }


}
