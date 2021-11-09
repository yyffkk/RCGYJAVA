package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookGoodsService;
import com.api.model.jcook.dto.RecommendGoodsSearch;
import com.api.vo.jcook.appGoods.OneCategoryVo;
import com.api.vo.jcook.appGoods.RecommendGoodsListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端
 */
@RestController
@RequestMapping("app/user/jcook")
public class AppJcookGoodsController {
    @Resource
    AppJcookGoodsService appJcookGoodsService;


    /**
     * 查询已上架的SKU总数
     * @return map
     */
    @GetMapping("/skuTotal")
    public Map<String,Object> skuTotal(){
        return appJcookGoodsService.skuTotal();
    }

    /**
     * 查询入驻品牌数
     * @return map
     */
    @GetMapping("/settledBrandsNum")
    public Map<String,Object> settledBrandsNum(){
        return appJcookGoodsService.settledBrandsNum();
    }

    /**
     * 查询今日上新产品件数
     * @return map
     */
    @GetMapping("/newProductsTodayNum")
    public Map<String,Object> newProductsTodayNum(){
        return appJcookGoodsService.newProductsTodayNum();
    }

    /**
     * 查询首页所有显示的一级分类
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findAllOneCategory")
    public Map<String,Object> findAllOneCategory(int pageNum,int size){

        PageHelper.startPage(pageNum,size);
        List<OneCategoryVo> oneCategoryVoList = appJcookGoodsService.findAllOneCategory();
        PageInfo<OneCategoryVo> pageInfo = new PageInfo<>(oneCategoryVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询最大人气值的几个(热搜及爆品推荐【爆品推荐后期用购买量来判断】)
     * @param num 取前几个
     * @return map
     */
    @GetMapping("/findMaxPopularity")
    public Map<String,Object> findMaxPopularity(int num){
        return appJcookGoodsService.findMaxPopularity(num);
    }


    /**
     * 查询综合推荐商品列表
     * @return map
     */
    @GetMapping("/findRecommendGoodsList")
    public Map<String,Object> findRecommendGoodsList(RecommendGoodsSearch recommendGoodsSearch){
        PageHelper.startPage(recommendGoodsSearch.getPageNum(),recommendGoodsSearch.getSize());
        List<RecommendGoodsListVo> recommendGoodsLists = appJcookGoodsService.findRecommendGoodsList(recommendGoodsSearch);
        PageInfo<RecommendGoodsListVo> pageInfo = new PageInfo<>(recommendGoodsLists);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询商品详情
     * @param shopId 商品主键id
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/findGoodsDetail")
    public Map<String,Object> findGoodsDetail(Integer shopId,Integer id){
        return appJcookGoodsService.findGoodsDetail(shopId,id);
    }

    /**
     * 查询商品详情 bigInfo大图信息【加载太慢了所以异步查询该接口】
     * @param shopId 商品主键id
     * @return map
     */
    @GetMapping("/findGoodsDetailBigInfo")
    public Map<String,Object> findGoodsDetailBigInfo(Integer shopId){
        return appJcookGoodsService.findGoodsDetailBigInfo(shopId);
    }

}
