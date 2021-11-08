package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品价格修改
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkuPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品编码
     */
    @JSONField(name = "sku_id")
    private BigInteger skuId;
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
}
