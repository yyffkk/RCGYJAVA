package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  收货地址 DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JcookAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户主键id
     */
    private Integer residentId;
    /**
     * 收货人
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 所在地区
     */
    private Integer location;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 是否为默认地址（0.否，1.是）
     */
    private Integer isDefault;
}
