package com.api.model.jcook.manageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 修改商品价格 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookUpdatePriceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品主键id
     */
    private Integer id;
    /**
     * 售卖价
     */
    private BigDecimal sellPrice;
    /**
     * 折扣价（划线价）
     */
    private BigDecimal discountPrice;
}
