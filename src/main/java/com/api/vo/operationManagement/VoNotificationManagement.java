package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 通知信息Vo list 回显
 */
public class VoNotificationManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 推送对象
     */
    private Integer pushObject;
    /**
     * app阅读量
     */
    private Integer readingVolume;
    /**
     * 推送状态
     */
    private Integer pushStatus;
    /**
     * 推送时间
     */
    private Date pushDate;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 更新时间
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "VoNotificationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pushObject=" + pushObject +
                ", readingVolume=" + readingVolume +
                ", pushStatus=" + pushStatus +
                ", pushDate=" + pushDate +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
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

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
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

    public VoNotificationManagement() {
    }

    public VoNotificationManagement(Integer id, String title, Integer pushObject, Integer readingVolume, Integer pushStatus, Date pushDate, String createName, Date updateDate) {
        this.id = id;
        this.title = title;
        this.pushObject = pushObject;
        this.readingVolume = readingVolume;
        this.pushStatus = pushStatus;
        this.pushDate = pushDate;
        this.createName = createName;
        this.updateDate = updateDate;
    }
}
