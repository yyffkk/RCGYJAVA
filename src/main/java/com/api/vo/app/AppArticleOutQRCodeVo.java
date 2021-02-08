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
     * 业主姓名
     */
    private String residentName;
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
                ", residentName='" + residentName + '\'' +
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public AppArticleOutQRCodeVo() {
    }

    public AppArticleOutQRCodeVo(Integer id, String roomName, Integer applicantId, String residentName, Date effectiveTime) {
        this.id = id;
        this.roomName = roomName;
        this.applicantId = applicantId;
        this.residentName = residentName;
        this.effectiveTime = effectiveTime;
    }
}
