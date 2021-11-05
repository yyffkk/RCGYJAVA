package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设置轮播信息model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingNewsRotation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资讯主键id
     */
    private Integer newsId;
    /**
     * 是否轮播，1.轮播，0.不轮播
     */
    private Integer isRotation;
    /**
     * 轮播权重
     */
    private Integer rotationWeight;
}
