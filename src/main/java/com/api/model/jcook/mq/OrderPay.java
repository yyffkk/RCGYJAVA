package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品订单支付成功
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPay implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 时间戳
     */
    @JSONField(name = "timestamp")
    private Long timestamp;
    /**
     * 渠道id
     */
    @JSONField(name = "channel_id")
    private Long channelId;
    /**
     * appKey
     */
    @JSONField(name = "app_key")
    private String appKey;
    /**
     * 渠道订单id
     */
    @JSONField(name = "order_channel_id")
    private String orderChannelId;
    /**
     * jcook订单id
     */
    @JSONField(name = "order_id")
    private BigInteger orderId;
    /**
     * jcook根订单id
     */
    @JSONField(name = "root_order_id")
    private BigInteger rootOrderId;
    /**
     * jcook父订单id
     */
    @JSONField(name = "parent_order_id")
    private BigInteger parentOrderId;
    /**
     * 支付时间
     */
    @JSONField(name = "pay_time")
    private String payTime;
    /**
     * 支付金额
     */
    @JSONField(name = "pay_fee")
    private String payFee;
}
