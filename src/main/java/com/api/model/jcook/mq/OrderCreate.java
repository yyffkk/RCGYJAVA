package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * 商品订单创建
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreate implements Serializable {
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
     * 创建时间
     */
    @JSONField(name = "create_time")
    private String createTime;
    /**
     * 包含运费的金额
     */
    @JSONField(name = "total_fee")
    private String totalFee;
    /**
     * 运费
     */
    @JSONField(name = "freight_fee")
    private String freightFee;
    /**
     * sku 列表
     */
    @JSONField(name = "sku_list")
    private List<OrderCreateSkuInfo> skuList;
}
