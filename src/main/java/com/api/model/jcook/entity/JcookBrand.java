package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * jcook店铺
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookBrand implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 店铺主键id
     */
    private Integer jcookShopId;
    /**
     * 品牌名称
     */
    private String brandName;
}
