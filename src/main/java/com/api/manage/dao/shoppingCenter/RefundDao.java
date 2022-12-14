package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.vo.shoppingCenter.RefundVo;

import java.util.List;

public interface RefundDao {
    /**
     * 查询所有的退换货管理信息
     * @param refundSearch 退换货管理搜索条件
     * @return 退换货管理信息
     */
    List<RefundVo> list(RefundSearch refundSearch);

    /**
     * 审核
     * @param order 商品预约model（订单）
     * @return 影响行数
     */
    int examine(Order order);
}
