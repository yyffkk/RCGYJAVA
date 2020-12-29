package com.api.model.operationManagement;

import java.util.Date;

/**
 * 通知信息model
 */
public class NotificationManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
    /**
     * 通知后缀
     */
    private String suffix;
    /**
     * 推送对象
     */
    private Integer pushObject;
    /**
     * 定时推送时间
     */
    private Date timingPush;
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
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "NotificationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", suffix='" + suffix + '\'' +
                ", pushObject=" + pushObject +
                ", timingPush=" + timingPush +
                ", readingVolume=" + readingVolume +
                ", pushStatus=" + pushStatus +
                ", pushDate=" + pushDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getPushObject() {
        return pushObject;
    }

    public void setPushObject(Integer pushObject) {
        this.pushObject = pushObject;
    }

    public Date getTimingPush() {
        return timingPush;
    }

    public void setTimingPush(Date timingPush) {
        this.timingPush = timingPush;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public NotificationManagement() {
    }

    public NotificationManagement(Integer id, String title, String content, String suffix, Integer pushObject, Date timingPush, Integer readingVolume, Integer pushStatus, Date pushDate, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.suffix = suffix;
        this.pushObject = pushObject;
        this.timingPush = timingPush;
        this.readingVolume = readingVolume;
        this.pushStatus = pushStatus;
        this.pushDate = pushDate;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
