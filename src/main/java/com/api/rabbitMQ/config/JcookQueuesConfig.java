package com.api.rabbitMQ.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jcook队列配置
 */
@Component
public class JcookQueuesConfig {
    private static final String appKey = "b7964889cedfdf429bfc7fae0001ff46";

    //商品信息修改
    public static final String skuChange = "sku.change.queue."+appKey;
    //商品价格修改
    public static final String skuPrice = "sku.price.queue."+appKey;
    //订单创建
    public static final String orderCreate = "order.create.queue."+appKey;
    //订单支付成功
    public static final String orderPay = "order.pay.queue."+appKey;
    //订单出库
    public static final String orderStockOut = "order.stock.out.queue."+appKey;
    //订单完成
    public static final String orderFinished = "order.finished.queue."+appKey;
    //订单取消
    public static final String orderCancel = "order.cancel.queue."+appKey;
    //所有退款
    public static final String anyRefund = "any.refund.queue."+appKey;
    //售后服务单创建
    public static final String afsCreate = "afs.create.queue."+appKey;
    //售后服务全流程
    public static final String afsStep = "afs.step.queue."+appKey;
}
