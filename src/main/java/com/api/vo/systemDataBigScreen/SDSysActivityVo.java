package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 社区活动Vo 回显
 */
public class SDSysActivityVo {
    /**
     * 活动标题
     */
    private String title;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名结束时间
     */
    private Date registrationEndTime;

    @Override
    public String toString() {
        return "SDSysActivityVo{" +
                "title='" + title + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public SDSysActivityVo() {
    }

    public SDSysActivityVo(String title, Date registrationStartTime, Date registrationEndTime) {
        this.title = title;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
    }
}
