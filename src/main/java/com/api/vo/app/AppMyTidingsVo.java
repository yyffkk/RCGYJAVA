package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 我的动态Vo list 回显
 */
public class AppMyTidingsVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgUrl;
    /**
     * 发布时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppMyTidingsVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", imgUrl=" + imgUrl +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppMyTidingsVo() {
    }

    public AppMyTidingsVo(Integer id, String content, List<VoResourcesImg> imgUrl, Date createDate) {
        this.id = id;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createDate = createDate;
    }
}
