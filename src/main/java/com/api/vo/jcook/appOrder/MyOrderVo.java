package com.api.vo.jcook.appOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 我的订单Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单主键id
     */
    private Integer id;
    /**
     * 小蜜蜂的订单号
     */
    private String code;
    /**
     * 交易状态(0.交易创建并等待买家付款,1.未付款交易超时关闭或支付完成后全额退款,2.交易支付成功（待发货）,3.交易结束并不可退款，4.出库（待收货）,5.订单完成9.取消订单10.发生拆单)
     */
    private Integer tradeStatus;
    /**
     * 付款方式（1.支付宝）
     */
    private BigDecimal payType;
    /**
     * 付款金额(含运费)
     */
    private BigDecimal payPrice;
    /**
     * 运费
     */
    private BigDecimal freightFee;
    /**
     * 我的订单详情Vo List集合
     */
    private List<MyOrderListVo> myOrderListVoList;
}
