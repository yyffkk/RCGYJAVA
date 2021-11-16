package com.api.app.service.jcook;

import com.api.model.jcook.dto.DeleteShoppingCartDTO;
import com.api.model.jcook.dto.InsertShoppingCartDTO;
import com.api.model.jcook.dto.UpdateShoppingCartNumDTO;

import java.util.Map;

public interface AppJcookShoppingCartService {
    /**
     * 我的购物车
     * @param id 用户主键id
     * @return map
     */
    Map<String, Object> myShoppingCart(Integer id);

    /**
     * 加入购物车
     * @param insertShoppingCartDTO 加入购物车model
     * @return map
     */
    Map<String, Object> insertShoppingCart(InsertShoppingCartDTO insertShoppingCartDTO);

    /**
     * 更改购物车商品数量
     * @param updateShoppingCartNumDTO 修改购物车数量model
     * @return map
     */
    Map<String, Object> updateShoppingCartNum(UpdateShoppingCartNumDTO updateShoppingCartNumDTO);

    /**
     * 删除购物车商品
     * @param deleteShoppingCartDTO 删除购物车model
     * @return map
     */
    Map<String, Object> deleteShoppingCart(DeleteShoppingCartDTO deleteShoppingCartDTO);
}
