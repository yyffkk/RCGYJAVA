package com.api.alipay.service;

import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.app.AppRepairOrder;
import com.api.model.app.UserIdAndRepairId;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AlipayService {
//    String getAliPayOrderStr(OrderTest orderTest);
//
//    String notify(Map<String, String> conversionParams);

    Map<String,Object> alipay(AppDailyPaymentOrder appDailyPaymentOrder);

    String getAlipayNotifyInfoOfCombinedPayment(HttpServletRequest request);

    Integer checkAlipay(String outTradeNo);

    Map<String, Object> dailyPaymentAlipay(AppDailyPaymentOrder appDailyPaymentOrder);

    String dailyPaymentNotifyInfo(HttpServletRequest request);

    Map<String,Object> dailyPaymentCheckAlipay(String outTradeNo);

    Map<String, Object> reportRepairAlipay(AppRepairOrder appRepairOrder);

    String reportRepairNotifyInfo(HttpServletRequest request, String userName, Integer userId);

    Map<String, Object> reportRepairCheckAlipay(String outTradeNo);

}
