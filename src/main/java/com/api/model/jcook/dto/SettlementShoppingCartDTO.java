package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 结算购物车model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettlementShoppingCartDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地址主键id（为null则为默认地址）
     */
    private Integer addressId;
    /**
     * 结算商品集合
     */
    private List<SettlementGoodsDTO> settlementGoodsDTOList;
    /**
     * 用户主键id
     */
    private Integer residentId;
}
