package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderVo> list(OrderSearch orderSearch);

    Map<String, Object> deliverGoods(Order order);

    Map<String, Object> arrivalGoods(Order order);
}
