package com.api.model.jcook.mq;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * 商品订单出库--物流信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStockOutPackage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 物流公司
     */
    @JSONField(name = "logistics_name")
    private String logisticsName;
    /**
     * 物流公司编号
     */
    @JSONField(name = "logistics_code")
    private BigInteger logisticsCode;
    /**
     * 运单号
     */
    @JSONField(name = "waybill_code")
    private String waybillCode;
    /**
     * 出库时间
     */
    @JSONField(name = "outbound_time")
    private String outboundTime;
    /**
     * packageSku 列表
     */
    @JSONField(name = "sku_list")
    private List<OrderStockOutPackageSkuList> skuList;

}
