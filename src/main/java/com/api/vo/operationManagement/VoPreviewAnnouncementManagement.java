package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 公告管理预览Vo 回显
 */
public class VoPreviewAnnouncementManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告照片
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告发布时间
     */
    private Date releaseDate;
    /**
     * doc,docx文件路径
     */
    private String fileDocUrl;

    @Override
    public String toString() {
        return "VoPreviewAnnouncementManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrls=" + imgUrls +
                ", content='" + content + '\'' +
                ", releaseDate=" + releaseDate +
                ", fileDocUrl='" + fileDocUrl + '\'' +
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public VoPreviewAnnouncementManagement() {
    }

    public VoPreviewAnnouncementManagement(Integer id, String title, List<VoResourcesImg> imgUrls, String content, Date releaseDate, String fileDocUrl) {
        this.id = id;
        this.title = title;
        this.imgUrls = imgUrls;
        this.content = content;
        this.releaseDate = releaseDate;
        this.fileDocUrl = fileDocUrl;
    }
}
