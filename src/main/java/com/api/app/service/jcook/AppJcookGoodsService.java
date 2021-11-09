package com.api.app.service.jcook;

import com.api.model.jcook.dto.RecommendGoodsSearch;
import com.api.vo.jcook.appGoods.OneCategoryVo;
import com.api.vo.jcook.appGoods.RecommendGoodsListVo;

import java.util.List;
import java.util.Map;

public interface AppJcookGoodsService {
    /**
     * 查询SKU总数
     * @return map
     */
    Map<String, Object> skuTotal();

    /**
     * 查询入驻品牌数
     * @return map
     */
    Map<String, Object> settledBrandsNum();

    /**
     * 查询今日上新产品件数
     * @return map
     */
    Map<String, Object> newProductsTodayNum();

    /**
     * 查询首页所有显示的一级分类
     * @return 一级分类数据回显
     */
    List<OneCategoryVo> findAllOneCategory();

    /**
     * 查询最大人气值的几个
     * @param num 取前几个
     * @return map
     */
    Map<String, Object> findMaxPopularity(int num);

    /**
     * 查询推荐商品列表
     * @param recommendGoodsSearch 推荐商品搜索条件
     * @return map
     */
    List<RecommendGoodsListVo> findRecommendGoodsList(RecommendGoodsSearch recommendGoodsSearch);

    /**
     * 查询商品详情
     *
     * @param shopId
     * @param id 商品主键id
     * @return map
     */
    Map<String, Object> findGoodsDetail(Integer shopId, Integer id);
}
