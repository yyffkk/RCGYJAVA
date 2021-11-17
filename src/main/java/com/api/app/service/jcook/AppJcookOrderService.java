package com.api.app.service.jcook;

import com.api.model.jcook.dto.CreateOrderDTO;
import com.api.model.jcook.dto.JcookOrderSearch;

import java.util.Map;

public interface AppJcookOrderService {
    Map<String, Object> myOrder(JcookOrderSearch jcookOrderSearch);
}
