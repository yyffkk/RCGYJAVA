package com.api.vo.jcook.appAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市Vo 信息回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
}
