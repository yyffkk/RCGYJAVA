package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 活动管理
 */
public class ButlerActivityVo {
    /**
     * 活动管理主键id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 主办方名称
     */
    private String sponsorName;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名结束时间
     */
    private Date registrationEndTime;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 活动照片集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerActivityVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sponsorName='" + sponsorName + '\'' +
                ", location='" + location + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", createDate=" + createDate +
                ", imgUrls=" + imgUrls +
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

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerActivityVo() {
    }

    public ButlerActivityVo(Integer id, String title, String sponsorName, String location, Date registrationStartTime, Date registrationEndTime, Date createDate, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.sponsorName = sponsorName;
        this.location = location;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.createDate = createDate;
        this.imgUrls = imgUrls;
    }
}
