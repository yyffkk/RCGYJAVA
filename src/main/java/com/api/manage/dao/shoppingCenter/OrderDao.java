package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;

import java.util.List;

public interface OrderDao {
    /**
     * 查询所有的订单信息
     * @param orderSearch 订单管理 搜索条件
     * @return 订单信息
     */
    List<GoodsVo> list(OrderSearch orderSearch);
}
