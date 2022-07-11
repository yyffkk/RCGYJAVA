package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 地理新增model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeographyInsert implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 地理介绍
     */
    private String content;
    /**
     * 照片路径数组
     */
    private String[] imgUrls;
}
