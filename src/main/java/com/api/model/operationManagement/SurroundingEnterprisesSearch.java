package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 周边企业 搜索条件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurroundingEnterprisesSearch implements Serializable {
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
     * 企业名称
     */
    private String name;
    /**
     * 发布状态（1.发布，2.未发布）
     */
    private Integer releaseStatus;
}
