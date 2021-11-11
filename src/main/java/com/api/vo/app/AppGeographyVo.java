package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app 地理信息 Vo回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppGeographyVo implements Serializable {
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
     * 创建时间
     */
    private Date createDate;
    /**
     * 地理照片集合
     */
    private List<VoResourcesImg> imgList;
}
