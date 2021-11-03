package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 户型说明 findById Vo回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysHouseTypeDescriptionFBIVo implements Serializable {
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
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
}
