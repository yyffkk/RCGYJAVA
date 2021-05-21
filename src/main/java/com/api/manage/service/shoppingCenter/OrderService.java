package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;

import java.util.List;

public interface OrderService {
    List<OrderVo> list(OrderSearch orderSearch);
}
