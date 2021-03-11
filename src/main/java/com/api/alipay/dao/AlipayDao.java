package com.api.alipay.dao;

import com.api.model.alipay.AliPaymentOrder;

public interface AlipayDao {

    /**
     * 创建商户支付宝订单
     * @param aliPaymentOrder 支付宝订单
     */
    void createAlipayMentOrder(AliPaymentOrder aliPaymentOrder);

    /**
     * 根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
     * @param outTradeNo out_trade_no【商户系统的唯一订单号】
     * @return 支付宝订单信息
     */
    AliPaymentOrder selectByOutTradeNo(String outTradeNo);

    /**
     * 根据主键修改 数据库支付宝信息
     * @param aliPaymentOrder 支付宝订单
     * @return 影响行数
     */
    int updateByPrimaryKey(AliPaymentOrder aliPaymentOrder);
}
