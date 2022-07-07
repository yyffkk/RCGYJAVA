package com.api.model.app;

import java.util.Date;

/**
 * app社区活动报名人信息
 */
public class AppActivityRegistration {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 活动id（取自活动管理表）
     */
    private Integer activityId;
    /**
     * 报名人（取自住户表）
     */
    private Integer residentId;
    /**
     * 报名时间
     */
    private Date registrationDate;

    @Override
    public String toString() {
        return "AppActivityRegistration{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", residentId=" + residentId +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AppActivityRegistration() {
    }

    public AppActivityRegistration(Integer id, Integer activityId, Integer residentId, Date registrationDate) {
        this.id = id;
        this.activityId = activityId;
        this.residentId = residentId;
        this.registrationDate = registrationDate;
    }
}
