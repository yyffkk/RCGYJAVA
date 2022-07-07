package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 社区介绍Vo findById 回显
 */
public class VoFBICommunityIntroduction {
    /**
     * 社区介绍主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 启用状态 ，1.启用中，2.未启用
     */
    private Integer status;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFBICommunityIntroduction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createName='" + createName + '\'' +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFBICommunityIntroduction() {
    }

    public VoFBICommunityIntroduction(Integer id, String name, String content, Integer status, String createName, List<VoResourcesImg> imgList) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.createName = createName;
        this.imgList = imgList;
    }
}
