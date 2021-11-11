package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 周边企业 FBI Vo 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysSurroundingEnterprisesFBIVo implements Serializable {
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
     * 照片集合
     */
    private List<VoResourcesImg> imgList;

}
