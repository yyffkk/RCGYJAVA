package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品退款成功--skuList
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnyRefundSkuList implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * sku编码
     */
    @JSONField(name = "sku_id")
    private BigInteger skuId;
    /**
     * 商品名称
     */
    @JSONField(name = "sku_name")
    private String skuName;
    /**
     * 价格
     */
    @JSONField(name = "price")
    private String price;
    /**
     * 数量
     */
    @JSONField(name = "quantity")
    private Integer quantity;
}
