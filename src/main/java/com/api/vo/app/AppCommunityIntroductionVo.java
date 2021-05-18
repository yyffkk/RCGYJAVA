package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app 社区介绍Vo detail 回显
 */
public class AppCommunityIntroductionVo {
    /**
     * 主键id
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
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "AppCommunityIntroductionVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public AppCommunityIntroductionVo() {
    }

    public AppCommunityIntroductionVo(Integer id, String name, String content, Date createDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createDate = createDate;
        this.imgList = imgList;
    }
}
