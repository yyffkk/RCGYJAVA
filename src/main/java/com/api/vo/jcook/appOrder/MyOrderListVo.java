package com.api.vo.jcook.appOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 我的订单详情Vo 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderListVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
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
     * 商品单位
     */
    private String unit;
    /**
     *  0=未知 1=自营 2=其 他,商品类别
     */
    private Integer kind;
    /**
     * 重量（千克）
     */
    private Double weight;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 付款金额（售卖价*购买数量）
     */
    private BigDecimal payPrice;
}
