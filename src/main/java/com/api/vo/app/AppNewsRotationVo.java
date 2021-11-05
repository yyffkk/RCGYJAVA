package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * app资讯轮播图回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppNewsRotationVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资讯主键id
     */
    private Integer newsId;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯照片（取第一张）
     */
    private List<VoResourcesImg> voResourcesImgList;
}
