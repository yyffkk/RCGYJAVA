package com.api.vo.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 周边企业信息 Vo 回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSurroundingEnterprisesVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业介绍
     */
    private String content;
    /**
     * 发布状态，1.发布，2.未发布
     */
    private Integer releaseStatus;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date modifyDate;
    /**
     * 发布时间
     */
    private Date releaseDate;
}
