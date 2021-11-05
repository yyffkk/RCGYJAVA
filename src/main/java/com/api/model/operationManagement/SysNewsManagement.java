package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 资讯管理信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysNewsManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键Id
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
     * 资讯内容
     */
    private String content;
    /**
     * 资讯分类主键Id【资讯类型】
     */
    private Integer newsCategoryId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 照片路径信息
     */
    private String[] imgUrls;
    /**
     * 是否轮播，1.轮播，0.不轮播
     */
    private Integer isRotation;
    /**
     * 轮播权重
     */
    private Integer rotationWeight;


}
