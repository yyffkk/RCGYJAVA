package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 户型说明model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysHouseTypeDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 户型名称
     */
    private String name;
    /**
     * 户型说明
     */
    private String content;
    /**
     * 发布状态：1.未发布，2.已发布
     */
    private Integer status;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改人时间
     */
    private Date modifyDate;
    /**
     * 照片文件路径数组
     */
    private String[] fileUrls;
}
