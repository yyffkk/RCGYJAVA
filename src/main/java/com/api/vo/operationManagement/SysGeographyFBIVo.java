package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 地理信息 FBI Vo回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysGeographyFBIVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 地理名称
     */
    private String name;
    /**
     * 地理介绍
     */
    private String content;
    /**
     * 地理照片集合
     */
    private List<VoResourcesImg> imgList;
}
