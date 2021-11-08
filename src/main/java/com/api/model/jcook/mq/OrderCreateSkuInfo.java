package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品订单创建-sku列表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateSkuInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * sku编码
     */
    @JSONField(name = "sku_id")
    private BigInteger skuId;
    /**
     * 数量
     */
    @JSONField(name = "quantity")
    private Integer quantity;
    /**
     * 价格
     */
    @JSONField(name = "price")
    private String price;
    /**
     * sku 名称
     */
    @JSONField(name = "sku_name")
    private String skuName;
    /**
     * 主体
     */
    @JSONField(name = "url")
    private String url;
}
