package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app户型说明 Vo 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppHouseTypeDescriptionVo implements Serializable {
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
     * 发布开始时间
     */
    private Date releaseDate;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
}
