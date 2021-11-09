package com.api.vo.jcook.appGoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品详情-specification规格参数-attribute列表 Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetailSpecificationAttributeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 键
     */
    private String name;
    /**
     * 值
     */
    private String value;
}
