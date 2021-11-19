package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * app 资讯信息Vo list 回显
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppNewsVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯创建时间
     */
    private Date createDate;
    /**
     * 浏览量
     */
    private Integer views;
    /**
     * 资讯照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

}
