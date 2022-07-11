package com.api.vo.jcook.manageOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * manage jcook商品订单详情-skuList 管理Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookOrderDetailSkuListVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * sku编码
     */
    private BigInteger skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 主图url
     */
    private String mainPhoto;
    /**
     * 售卖价
     */
    private BigDecimal sellPrice;
    /**
     * 0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
    /**
     * 重量（千克）
     */
    private Double weight;
    /**
     * 商品单位
     */
    private String unit;
    /***
     * 购买数量
     */
    private Integer num;
    /**
     * 付款金额（售卖价*购买数量）
     */
    private BigDecimal payPrice;
}
