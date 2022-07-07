package com.api.vo.app;

import java.util.Date;

/**
 * app 物品出户 二维码信息Vo
 */
public class AppArticleOutQRCodeVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 出户房产名称
     */
    private String roomName;
    /**
     * 申请出户人id
     */
    private Integer applicantId;
    /**
     * 申请出户人姓名
     */
    private String applicantName;
    /**
     * 有效时间 = 预计时间 + 24小时
     */
    private Date effectiveTime;

    @Override
    public String toString() {
        return "AppArticleOutQRCodeVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", applicantId=" + applicantId +
                ", applicantName='" + applicantName + '\'' +
                ", effectiveTime=" + effectiveTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public AppArticleOutQRCodeVo() {
    }

    public AppArticleOutQRCodeVo(Integer id, String roomName, Integer applicantId, String applicantName, Date effectiveTime) {
        this.id = id;
        this.roomName = roomName;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.effectiveTime = effectiveTime;
    }
}
