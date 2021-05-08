package com.api.app.service.shoppingCenter;

import com.api.model.app.AppGoodsAppointment;
import com.api.vo.app.AppGoodsVo;

import java.util.List;
import java.util.Map;

public interface ShoppingService {
    Map<String, Object> list(Integer parentId);

    Map<String, Object> findTopGoods();

    List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId);

    Map<String, Object> findDetailByGoodsId(Integer goodsId, Integer id);

    Map<String, Object> findTopGoodsBySupplierId(Integer supplierId);

    Map<String, Object> goodsAppointment(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id);

    List<AppGoodsVo> goodsSearch(String searchName);
}
