package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;

import java.util.List;

public interface OrderDao {
    /**
     * 查询所有的订单信息
     * @param orderSearch 订单管理 搜索条件
     * @return 订单信息
     */
    List<OrderVo> list(OrderSearch orderSearch);

    /**
     * 发货
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int deliverGoods(Order order);

    /**
     * 根据商品预约主键id查询商品预约状态
     * @param id 商品预约主键id
     * @return 商品预约状态
     */
    int findStatusById(Integer id);

    /**
     * 商品到货
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int arrivalGoods(Order order);

    /**
     * 根据商品预约订单主键id查询商品预约订单信息
     * @param id 商品预约订单主键id
     * @return 商品预约model（订单）
     */
    Order findById(Integer id);
}
