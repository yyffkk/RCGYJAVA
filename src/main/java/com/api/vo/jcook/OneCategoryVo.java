package com.api.vo.jcook;

import com.api.vo.resources.VoResourcesImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 一级分类数据回显
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneCategoryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 分类主键id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类照片
     */
    private List<VoResourcesImg> imgUrls;
}
