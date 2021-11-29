package com.api.app.service.jcook;

import com.api.model.jcook.appDto.AppDeleteDTO;
import com.api.model.jcook.appDto.AppJcookCancelOrderDTO;
import com.api.model.jcook.appDto.JcookOrderSearch;
import com.api.vo.jcook.appOrder.MyOrderVo;

import java.util.List;
import java.util.Map;

public interface AppJcookOrderService {
    List<MyOrderVo> myOrder(JcookOrderSearch jcookOrderSearch);

    /**
     * app取消订单 DTO
     * @param appJcookCancelOrderDTO app取消订单 DTO
     * @return map
     */
    Map<String, Object> cancel(AppJcookCancelOrderDTO appJcookCancelOrderDTO);

    /**
     * app删除订单
     * @param appDelete app删除DTO
     * @return map
     */
    Map<String, Object> appDelete(AppDeleteDTO appDelete);
}
