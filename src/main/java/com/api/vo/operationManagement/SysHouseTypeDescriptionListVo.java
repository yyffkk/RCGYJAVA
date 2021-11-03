package com.api.vo.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 户型说明 list Vo回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysHouseTypeDescriptionListVo implements Serializable {
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
     * 户型内容
     */
    private String content;
    /**
     * 发布状态：1.未发布，2.已发布
     */
    private Integer status;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 发布开始时间
     */
    private Date releaseDate;
}
