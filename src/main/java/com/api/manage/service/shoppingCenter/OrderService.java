package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;

import java.util.List;

public interface OrderService {
    List<GoodsVo> list(OrderSearch orderSearch);
}
