package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 商品订单出库--物流信息--skuList列表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStockOutPackageSkuList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    @JSONField(name = "sku_id")
    private BigInteger skuId;
    /**
     * 商品名称
     */
    @JSONField(name = "sku_name")
    private String skuName;
    /**
     * 数量
     */
    @JSONField(name = "quantity")
    private Integer quantity;
}
