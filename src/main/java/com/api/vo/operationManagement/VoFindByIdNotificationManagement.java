package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 通知信息 findById 回显
 */
public class VoFindByIdNotificationManagement {
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
     * 推送对象，正数：楼栋id，-1全体业主，-2全体租户
     */
    private Integer pushObject;
    /**
     * 推送状态（1.未推送(定时推送)，2.已推送）
     */
    private Integer pushStatus;
    /**
     * 定时推送时间（当状态为 1.未推送 时显示）
     */
    private Date timingPush;
    /**
     * 推送时间（当状态为 2.已推送 时显示）
     */
    private Date pushDate;

    @Override
    public String toString() {
        return "VoFindByIdNotificationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", suffix='" + suffix + '\'' +
                ", pushObject=" + pushObject +
                ", pushStatus=" + pushStatus +
                ", timingPush=" + timingPush +
                ", pushDate=" + pushDate +
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

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Date getTimingPush() {
        return timingPush;
    }

    public void setTimingPush(Date timingPush) {
        this.timingPush = timingPush;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public VoFindByIdNotificationManagement() {
    }

    public VoFindByIdNotificationManagement(Integer id, String title, String content, String suffix, Integer pushObject, Integer pushStatus, Date timingPush, Date pushDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.suffix = suffix;
        this.pushObject = pushObject;
        this.pushStatus = pushStatus;
        this.timingPush = timingPush;
        this.pushDate = pushDate;
    }
}
