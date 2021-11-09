package com.api.model.jcook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JcookCity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父类主键id
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型：0.国家，1.省，2.市，3.县
     */
    private Integer type;
}
