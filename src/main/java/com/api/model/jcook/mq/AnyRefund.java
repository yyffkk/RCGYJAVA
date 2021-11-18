package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * 商品退款成功
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnyRefund implements Serializable {
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
     * 1=售后 2=取消
     */
    @JSONField(name = "refund_type")
    private Integer refundType;
    /**
     * 退款金额
     */
    @JSONField(name = "refund_fee")
    private String refundFee;
    /**
     * 售后有值，非售后为0
     */
    @JSONField(name = "afs_service_id")
    private BigInteger afsServiceId;
    /**
     * 退款时间，d
     */
    @JSONField(name = "refund_time")
    private String refundTime;
    /**
     * sku售后时候有值
     */
    @JSONField(name = "sku_list")
    private List<AnyRefundSkuList> skuList;
}
