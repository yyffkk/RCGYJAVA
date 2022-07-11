package com.api.vo.jcook.appGoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 商品specification规格参数Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetailSpecificationVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 组名
     */
    private String groupName;
    /**
     * attribute 列表
     */
    private List<GoodsDetailSpecificationAttributeVo> attribute;
}
