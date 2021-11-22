package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 修改购物车数量model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateShoppingCartNumDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品主键id
     */
    private Integer jcookGoodsId;
    /**
     * 用户主键id
     */
    private Integer residentId;
    /**
     * 购买商品数量
     */
    private Integer num;
}
