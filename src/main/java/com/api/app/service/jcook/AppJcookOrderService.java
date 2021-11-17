package com.api.app.service.jcook;

import com.api.model.jcook.dto.CreateOrderDTO;
import com.api.model.jcook.dto.JcookOrderSearch;
import com.api.vo.jcook.appOrder.MyOrderVo;

import java.util.List;
import java.util.Map;

public interface AppJcookOrderService {
    List<MyOrderVo> myOrder(JcookOrderSearch jcookOrderSearch);
}
