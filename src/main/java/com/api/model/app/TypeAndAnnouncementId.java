package com.api.model.app;

/**
 * 用户类型 和 社区公告主键id
 */
public class TypeAndAnnouncementId {
    /**
     * 用户类型
     */
    private Integer type;
    /**
     * 社区公告主键id
     */
    private Integer announcementId;

    @Override
    public String toString() {
        return "TypeAndAnnouncementId{" +
                "type=" + type +
                ", announcementId=" + announcementId +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public TypeAndAnnouncementId() {
    }

    public TypeAndAnnouncementId(Integer type, Integer announcementId) {
        this.type = type;
        this.announcementId = announcementId;
    }
}
