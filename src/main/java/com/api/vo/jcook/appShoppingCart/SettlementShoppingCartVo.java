package com.api.vo.jcook.appShoppingCart;

import com.api.vo.jcook.appAddress.DefaultAddressVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 结算购物车Vo 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettlementShoppingCartVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认地址
     */
    private DefaultAddressVo defaultAddressVo;
    /**
     * 订单商品集合
     */
    private List<MyShoppingCartVo> myShoppingCartVoList;
    /**
     * 运费
     */
    private Double fee;
}
