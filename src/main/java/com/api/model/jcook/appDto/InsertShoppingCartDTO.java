package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 加入购物车model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertShoppingCartDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 用户主键id
     */
    private Integer residentId;
    /**
     * jcook商品主键id
     */
    private Integer jcookGoodsId;
}
