package com.api.alipay.service;

import com.api.model.alipay.SysLeaseOrder;
import com.api.model.alipay.SysLeaseRentOrder;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppRepairOrder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AlipayService {
//    String getAliPayOrderStr(OrderTest orderTest);
//
//    String notify(Map<String, String> conversionParams);

//    Map<String,Object> alipay(AppDailyPaymentOrder appDailyPaymentOrder);
//
//    String getAlipayNotifyInfoOfCombinedPayment(HttpServletRequest request);
//
//    Integer checkAlipay(String outTradeNo);

    Map<String, Object> dailyPaymentAlipay(AppDailyPaymentOrder appDailyPaymentOrder);

    String dailyPaymentNotifyInfo(HttpServletRequest request);

    Map<String,Object> dailyPaymentCheckAlipay(String code);

    Map<String, Object> reportRepairAlipay(AppRepairOrder appRepairOrder);

    String reportRepairNotifyInfo(HttpServletRequest request, String userName, Integer userId);

    Map<String, Object> reportRepairCheckAlipay(String code);

    Map<String, Object> shoppingAlipay(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id);

    String shoppingNotifyInfo(HttpServletRequest request, String userName, Integer userId);

    Map<String, Object> shoppingCheckAlipay(String code);

    Map<String, Object> leaseAlipay(SysLeaseOrder sysLeaseOrder, Integer id);

    String leaseNotifyInfo(HttpServletRequest request, String userName, Integer userId);

    Map<String, Object> leaseCheckAlipay(String code);

    Map<String, Object> leaseRentOrderAlipay(SysLeaseRentOrder sysLeaseRentOrder, Integer id);

    String leaseRentOrderNotifyInfo(HttpServletRequest request, String userName, Integer userId);

    Map<String, Object> leaseRentOrderCheckAlipay(String code);
}
