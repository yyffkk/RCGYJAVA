package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app社区公告详情信息Vo 回显
 */
public class ButlerAnnouncementDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;
    /**
     * doc，docx文件路径
     */
    private String fileDocUrl;
    /**
     * doc，docx文件名称
     */
    private String fileDocName;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 公告照片资源信息
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerAnnouncementDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", releaseTime=" + releaseTime +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public String getFileDocName() {
        return fileDocName;
    }

    public void setFileDocName(String fileDocName) {
        this.fileDocName = fileDocName;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerAnnouncementDetailVo() {
    }

    public ButlerAnnouncementDetailVo(Integer id, String title, String content, String fileDocUrl, String fileDocName, Date releaseTime, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.releaseTime = releaseTime;
        this.imgUrls = imgUrls;
    }
}
