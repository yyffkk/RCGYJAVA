package com.api.manage.controller.shoppingCenter;

import com.api.manage.service.shoppingCenter.GoodsService;
import com.api.model.shoppingCenter.Goods;
import com.api.model.shoppingCenter.GoodsSearch;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.SupplierVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
        PageHelper.startPage(goodsSearch.getPageNum(),goodsSearch.getSize());
        List<GoodsVo> goodsVos = goodsService.list(goodsSearch);
        PageInfo<GoodsVo> pageInfo = new PageInfo<>(goodsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加商品信息
     * @param goods 商品信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Goods goods){
        return goodsService.insert(goods);
    }


    /**
     * 上架
     * @param id 商品主键id
     * @return map
     */
    @GetMapping("/loading")
    public Map<String,Object> loading(Integer id){
        return goodsService.loading(id);
    }

    /**
     * 下架
     * @param id 商品主键id
     * @return map
     */
    @GetMapping("/unloading")
    public Map<String,Object> unloading(Integer id){
        return goodsService.unloading(id);
    }


    /**
     * 批量删除商品
     * @param ids 商品主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return goodsService.delete(ids.getIds());
    }


}
