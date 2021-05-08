package com.api.app.service.shoppingCenter;

import com.api.vo.app.AppGoodsVo;

import java.util.List;
import java.util.Map;

public interface ShoppingService {
    Map<String, Object> list(Integer parentId);

    Map<String, Object> findTopGoods();

    List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId);

    Map<String, Object> findDetailByGoodsId(Integer goodsId);
}
