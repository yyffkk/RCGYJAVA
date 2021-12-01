package com.api.model.jcook.manageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 修改轮播图DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageJcookRotationUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 轮播图主键id
     */
    private Integer id;
    /**
     * sku编码
     */
    private BigInteger skuId;
    /**
     * 照片路径数组
     */
    private String[] imgUrls;
}
