package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * app分类
 */
public class AppCategoryVo {
    /**
     * 类目主键id
     */
    private Integer id;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目照片
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "AppCategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public AppCategoryVo() {
    }

    public AppCategoryVo(Integer id, String name, List<VoResourcesImg> imgList) {
        this.id = id;
        this.name = name;
        this.imgList = imgList;
    }
}
