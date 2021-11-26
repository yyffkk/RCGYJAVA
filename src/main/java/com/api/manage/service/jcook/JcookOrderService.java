package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookCancelOrderDTO;
import com.api.model.jcook.manageDto.ManageJcookOrderSearch;
import com.api.vo.jcook.manageOrder.ManageJcookOrderVo;

import java.util.List;
import java.util.Map;

public interface JcookOrderService {
    /**
     * 查询所有的商品订单信息
     * @param manageJcookOrderSearch manage jcook商品订单搜索条件
     * @return 商品订单信息
     */
    List<ManageJcookOrderVo> list(ManageJcookOrderSearch manageJcookOrderSearch);

    /**
     * 取消订单
     * @param manageJcookCancelOrderDTO 取消订单 DTO
     * @return map
     */
    Map<String, Object> cancel(ManageJcookCancelOrderDTO manageJcookCancelOrderDTO);

    /**
     * 查询订单详情
     * @param orderId 订单主键id
     * @return
     */
    Map<String, Object> findDetail(Integer orderId);
}
