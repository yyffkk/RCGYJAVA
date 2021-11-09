package com.api.vo.jcook.appBrand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品品牌信息 Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsBrandVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
}
