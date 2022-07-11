package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯管理搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchNewsManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 资讯编号
     */
    private String code;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯类型
     */
    private Integer newsCategoryId;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 发布开始时间
     */
    private Date createDateStart;
    /**
     * 发布结束时间
     */
    private Date createDateEnd;
    /**
     * 是否为轮播
     */
    private Integer isRotation;


}
