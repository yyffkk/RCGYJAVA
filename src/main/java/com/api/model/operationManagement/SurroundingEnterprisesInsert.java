package com.api.model.operationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 周边企业新增model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurroundingEnterprisesInsert implements Serializable {
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
     * 企业内容
     */
    private String content;
    /**
     * 发布状态，1.发布，2.未发布
     */
    private Integer releaseStatus;
    /**
     * 照片集合
     */
    private String[] imgUrls;
}
