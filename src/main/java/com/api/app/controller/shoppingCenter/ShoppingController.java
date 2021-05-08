package com.api.app.controller.shoppingCenter;

import com.api.app.service.shoppingCenter.ShoppingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app商场
 */
@RestController
@RequestMapping("manage/shop/category")
public class ShoppingController {

    @Resource
    ShoppingService shoppingService;

    /**
     * 查询所有的分类
     * @param parentId 父类id，如果为一级则为0
     * @return map
     */
    @GetMapping("/findAllCategory")
    public Map<String,Object> findAllCategory(Integer parentId){
        return shoppingService.list(parentId);
    }

}
