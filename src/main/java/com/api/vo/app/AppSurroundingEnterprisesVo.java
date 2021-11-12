package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app周边企业信息Vo 回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppSurroundingEnterprisesVo implements Serializable {
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
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 照片集合
     */
    private List<VoResourcesImg> imgList;
}
