package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 创建订单DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地址主键id
     */
    private Integer addressId;
    /**
     * 结算商品集合
     */
    private List<SettlementGoodsDTO> settlementGoodsDTOList;
    /**
     * 支付金额(含运费)
     */
    private BigDecimal payPrice;
    /**
     * 支付方式（1.支付宝，2.微信）
     */
    private Integer payType;
    /**
     * 用户主键id
     */
    private Integer residentId;
    /**
     * 支付人名称
     */
    private String payName;
    /**
     * 支付人联系方式
     */
    private String payTel;
}
