package com.api.vo.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯信息 Vo list 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoNewsManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 资讯编号
     */
    private String code;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯类型名称
     */
    private String newsCategoryName;
    /**
     * 是否轮播，1.轮播，0.不轮播
     */
    private Integer isRotation;
    /**
     * 轮播权重
     */
    private Integer rotationWeight;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 发布时间
     */
    private Date createDate;


}
