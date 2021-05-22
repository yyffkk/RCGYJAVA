package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 公告管理Vo findById 回显
 */
public class VoFindByIdAnnouncementManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 推送对象
     */
    private Integer pushObject;
    /**
     * 照片集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 文件路径
     */
    private String fileDocUrl;
    /**
     * doc文件名
     */
    private String fileDocName;
    /**
     * 状态（0.未发布，1.已发布）
     */
    private Integer status;
    /**
     * 定时发布时间
     */
    private Date scheduledReleaseTime;

    @Override
    public String toString() {
        return "VoFindByIdAnnouncementManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pushObject=" + pushObject +
                ", imgUrls=" + imgUrls +
                ", content='" + content + '\'' +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", status=" + status +
                ", scheduledReleaseTime=" + scheduledReleaseTime +
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

    public Integer getPushObject() {
        return pushObject;
    }

    public void setPushObject(Integer pushObject) {
        this.pushObject = pushObject;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getScheduledReleaseTime() {
        return scheduledReleaseTime;
    }

    public void setScheduledReleaseTime(Date scheduledReleaseTime) {
        this.scheduledReleaseTime = scheduledReleaseTime;
    }

    public VoFindByIdAnnouncementManagement() {
    }

    public VoFindByIdAnnouncementManagement(Integer id, String title, Integer pushObject, List<VoResourcesImg> imgUrls, String content, String fileDocUrl, String fileDocName, Integer status, Date scheduledReleaseTime) {
        this.id = id;
        this.title = title;
        this.pushObject = pushObject;
        this.imgUrls = imgUrls;
        this.content = content;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.status = status;
        this.scheduledReleaseTime = scheduledReleaseTime;
    }
}
