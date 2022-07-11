package com.api.vo.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 地理信息Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysGeographyVo implements Serializable {
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
     * 状态，1.启用，2.未启用
     */
    private Integer status;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 创建时间
     */
    private Date createDate;
}
