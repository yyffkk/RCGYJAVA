package com.api.vo.jcook.appAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 默认地址
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultAddressVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 收货人名称
     */
    private String name;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 所在地区名称
     */
    private String locationName;
    /**
     * 详细地址
     */
    private String addressDetail;
}
