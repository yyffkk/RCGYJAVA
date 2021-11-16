package com.api.app.service.jcook;

import java.util.Map;

public interface AppJcookShoppingCartService {
    /**
     * 我的购物车
     * @param id 用户主键id
     * @return map
     */
    Map<String, Object> myShoppingCart(Integer id);
}
