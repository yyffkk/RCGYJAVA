package com.api.app.service.jcook;

import com.api.model.jcook.appDto.JcookOrderSearch;
import com.api.vo.jcook.appOrder.MyOrderVo;

import java.util.List;

public interface AppJcookOrderService {
    List<MyOrderVo> myOrder(JcookOrderSearch jcookOrderSearch);
}
