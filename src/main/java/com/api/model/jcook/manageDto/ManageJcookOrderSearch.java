package com.api.model.jcook.manageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * manage jcook商品订单搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookOrderSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 小蜜蜂的订单号
     */
    private String code;
    /**
     * jcook的订单号
     */
    private String jcookCode;
    /**
     * 交易状态(0.交易创建并等待买家付款,1.未付款交易超时关闭或支付完成后全额退款,2.交易支付成功（待发货）,3.交易结束并不可退款，4.出库（待收货）,5.订单完成,6.申请取消,7.申请拒收，8.取消订单失败9.取消订单成功10.发生拆单,11.售后换新)
     */
    private Integer tradeStatus;
}
