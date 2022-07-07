package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 资讯信息Vo findById 回显
 */
public class VoFBINewsManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 资讯编号
     */
    private String code;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯内容
     */
    private String content;
    /**
     * 资讯分类名称
     */
    private String newsCategoryName;
    /**
     * 资讯分类主键id
     */
    private Integer newsCategoryId;
    /**
     * 资讯照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFBINewsManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", newsCategoryName='" + newsCategoryName + '\'' +
                ", newsCategoryId=" + newsCategoryId +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsCategoryName() {
        return newsCategoryName;
    }

    public void setNewsCategoryName(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
    }

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFBINewsManagement() {
    }

    public VoFBINewsManagement(Integer id, String code, String title, String content, String newsCategoryName, Integer newsCategoryId, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.newsCategoryName = newsCategoryName;
        this.newsCategoryId = newsCategoryId;
        this.imgList = imgList;
    }
}
