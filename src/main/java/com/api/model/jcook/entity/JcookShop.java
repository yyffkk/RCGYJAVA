package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * jcook店铺
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JcookShop implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 店铺名称
     */
    private String shopName;
}
