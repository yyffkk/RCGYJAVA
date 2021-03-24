package com.api.alipay.service;

import com.api.model.alipay.OrderTest;
import com.api.model.app.AppDailyPaymentOrder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AlipayService {
//    String getAliPayOrderStr(OrderTest orderTest);
//
//    String notify(Map<String, String> conversionParams);

    Map<String,Object> alipay(AppDailyPaymentOrder appDailyPaymentOrder);

    String getAlipayNotifyInfoOfCombinedPayment(HttpServletRequest request);

    Integer checkAlipay(String outTradeNo);
}
