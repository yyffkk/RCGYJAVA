package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 购物车model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookShoppingCart implements Serializable {
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
     * 用户主键id
     */
    private Integer residentId;
    /**
     * 购买数量
     */
    private Integer num;
}
