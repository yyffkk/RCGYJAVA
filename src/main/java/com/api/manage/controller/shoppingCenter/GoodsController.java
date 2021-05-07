package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.GoodsService;
import com.api.model.shoppingCenter.GoodsSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 商品管理
 */
@RestController
@RequestMapping("manage/shop/goods")
public class GoodsController {
    @Resource
    GoodsService goodsService;


    /**
     * 查询所有的商品信息
     * @param goodsSearch 商品管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(GoodsSearch goodsSearch){
        return null;
    }
}
