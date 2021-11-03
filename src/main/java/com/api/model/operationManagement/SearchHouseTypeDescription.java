package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 户型说明搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchHouseTypeDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 户型名称
     */
    private String name;
    /**
     * 发布状态：1.未发布，2.已发布
     */
    private String status;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 发布开始时间
     */
    private Date releaseDateStart;
    /**
     * 发布结束时间
     */
    private Date releaseDateEnd;
}
