package com.api.alipay.service;

import com.api.model.alipay.OrderTest;

import java.util.Map;

public interface AlipayService {
    String getAliPayOrderStr(OrderTest orderTest);

    String notify(Map<String, String> conversionParams);

    Byte checkAlipay(String outTradeNo);
}
