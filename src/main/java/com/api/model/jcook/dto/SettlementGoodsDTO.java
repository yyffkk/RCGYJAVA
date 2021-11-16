package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 结算商品model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettlementGoodsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 商品数量
     */
    private Integer num;
}
