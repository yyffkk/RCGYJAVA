package com.api.model.jcook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设置默认地址DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingDefaultAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地址主键id
     */
    private Integer addressId;
    /**
     * 用户主键id
     */
    private Integer residentId;
}
