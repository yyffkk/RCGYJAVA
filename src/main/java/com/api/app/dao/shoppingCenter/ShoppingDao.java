package com.api.app.dao.shoppingCenter;

import com.api.vo.app.AppCategoryVo;
import com.api.vo.app.AppGoodsDetailVo;
import com.api.vo.app.AppGoodsVo;

import java.util.List;

public interface ShoppingDao {
    /**
     * 查询所有的分类
     * @param parentId 父类id，如果为一级则为0
     * @return 所有的分类
     */
    List<AppCategoryVo> list(Integer parentId);

    /**
     * 查询订阅量最高的4件商品
     * @return 商品
     */
    List<AppGoodsVo> findTopGoods();

    /**
     * 根据分类主键id查询商品信息列表
     * @param categoryId 分类主键id
     * @return 商品信息列表
     */
    List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId);

    /**
     * 根据商品主键id查询商品详情
     * @param goodsId 商品主键id
     * @return 商品详情
     */
    AppGoodsDetailVo findDetailByGoodsId(Integer goodsId);
}
