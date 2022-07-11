package com.api.model.jcook.appDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 全部城市信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookCityAll implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 子城市集合
     */
    private List<JcookCityAll> cityList;
}
