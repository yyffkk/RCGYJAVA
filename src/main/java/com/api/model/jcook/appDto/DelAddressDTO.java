package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 删除收货地址 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 收货地址主键id
     */
    private Integer addressId;
    /**
     * 用户主键id
     */
    private Integer residentId;
}
