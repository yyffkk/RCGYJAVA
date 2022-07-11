package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * jcook轮播图
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookRotation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * sku编码
     */
    private BigInteger skuId;
}
