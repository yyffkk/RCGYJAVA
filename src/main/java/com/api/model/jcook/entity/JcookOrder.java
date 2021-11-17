package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * jcook订单model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 小蜜蜂的订单号
     */
    private String code;
    /**
     * jcook的订单号
     */
    private String jcookCode;
    /**
     * 支付宝的交易号
     */
    private String tradeNo;
    /**
     * 交易状态(0.交易创建并等待买家付款,1.未付款交易超时关闭或支付完成后全额退款,2.交易支付成功,3.交易结束并不可退款)
     */
    private Integer tradeStatus;
    /**
     * 支付人名称
     */
    private String payName;
    /**
     * 支付人联系方式
     */
    private String payTel;
    /**
     * 付款方式（1.支付宝，2.微信，3.现金，4.pos，5.预缴扣除，6.银行卡，7.支票，8.转账，9.开发商代付）
     */
    private Integer payType;
    /**
     * 付款金额
     */
    private BigDecimal payPrice;
    /**
     * 运费
     */
    private BigDecimal freightFee;
    /**
     * 收货人
     */
    private String receiverName;
    /**
     * 收货人手机号
     */
    private String receiverTel;
    /**
     * 所在地区名称
     */
    private String locationName;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 通知时间
     */
    private Date notifyDate;
    /**
     * 交易创建时间
     */
    private Date gmtCreate;
    /**
     * 交易付款时间
     */
    private Date gmtPayment;
    /**
     * 交易退款时间
     */
    private Date refund;
    /**
     * 交易结束时间
     */
    private Date gmtClose;
}
