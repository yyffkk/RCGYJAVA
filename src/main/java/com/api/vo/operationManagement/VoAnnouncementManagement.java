package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 公告管理Vo list 回显
 */
public class VoAnnouncementManagement {
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
     * 阅读量
     */
    private Integer readingVolume;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 定时发布时间
     */
    private Date scheduledReleaseTime;

    @Override
    public String toString() {
        return "VoAnnouncementManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pushObject=" + pushObject +
                ", readingVolume=" + readingVolume +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
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

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getScheduledReleaseTime() {
        return scheduledReleaseTime;
    }

    public void setScheduledReleaseTime(Date scheduledReleaseTime) {
        this.scheduledReleaseTime = scheduledReleaseTime;
    }

    public VoAnnouncementManagement() {
    }

    public VoAnnouncementManagement(Integer id, String title, Integer pushObject, Integer readingVolume, Integer status, String createName, Date updateDate, Date scheduledReleaseTime) {
        this.id = id;
        this.title = title;
        this.pushObject = pushObject;
        this.readingVolume = readingVolume;
        this.status = status;
        this.createName = createName;
        this.updateDate = updateDate;
        this.scheduledReleaseTime = scheduledReleaseTime;
    }
}
