package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 删除购物车model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteShoppingCartDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    private Integer residentId;
    /**
     * jcook商品主键id
     */
    private int[] jcookGoodsIds;
}
