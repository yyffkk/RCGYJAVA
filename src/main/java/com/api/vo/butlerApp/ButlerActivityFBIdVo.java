package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 活动详情Vo findById 回显
 */
public class ButlerActivityFBIdVo {
    /**
     * 活动管理主键id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 活动开始时间
     */
    private Date activityStartTime;
    /**
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 报名结束时间
     */
    private Date registrationEndTime;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerActivityFBIdVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", location='" + location + '\'' +
                ", registrationEndTime=" + registrationEndTime +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerActivityFBIdVo() {
    }

    public ButlerActivityFBIdVo(Integer id, String title, String content, Date activityStartTime, Date activityEndTime, String location, Date registrationEndTime, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.location = location;
        this.registrationEndTime = registrationEndTime;
        this.imgUrls = imgUrls;
    }
}
