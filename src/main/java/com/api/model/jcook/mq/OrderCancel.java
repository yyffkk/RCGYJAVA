package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品订单取消
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancel implements Serializable {
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
     * 取消时间
     */
    private String cancelTime;
    /**
     * 1=取消成功 2=取消失败 3=申请取消 4=申请拒收
     */
    private Integer status;
}
