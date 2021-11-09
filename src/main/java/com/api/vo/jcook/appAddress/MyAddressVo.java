package com.api.vo.jcook.appAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 我的地址 Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyAddressVo implements Serializable {
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
     * 所在地区
     */
    private Integer location;
    /**
     * 所在地区名称
     */
    private String locationName;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 是否为默认地址（0.否，1.是）
     */
    private Integer isDefault;
}
