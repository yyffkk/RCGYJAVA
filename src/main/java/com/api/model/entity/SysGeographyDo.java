package com.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 地理信息model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_geography")
public class SysGeographyDo implements Serializable {
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
     * 创建人主键id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人主键id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
}
