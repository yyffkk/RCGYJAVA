package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.vo.shoppingCenter.RefundVo;

import java.util.List;
import java.util.Map;

public interface RefundService {
    List<RefundVo> list(RefundSearch refundSearch);

    Map<String, Object> examine(Order order);

    Map<String, Object> exchangeGoods(Integer id);
}
