package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 社区活动详情Vo findById 回显
 */
public class AppActivityDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 活动开始时间
     */
    private Date activityStartTime;
    /**
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名截止时间
     */
    private Date registrationEndTime;
    /**
     * 已参与人数(已报名人数)
     */
    private Integer countRegistration;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 报名人头像资源集合（取前3）
     */
    private List<VoResourcesImg> headImgURls;

    @Override
    public String toString() {
        return "AppActivityDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", location='" + location + '\'' +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", countRegistration=" + countRegistration +
                ", imgUrls=" + imgUrls +
                ", headImgURls=" + headImgURls +
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getCountRegistration() {
        return countRegistration;
    }

    public void setCountRegistration(Integer countRegistration) {
        this.countRegistration = countRegistration;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public List<VoResourcesImg> getHeadImgURls() {
        return headImgURls;
    }

    public void setHeadImgURls(List<VoResourcesImg> headImgURls) {
        this.headImgURls = headImgURls;
    }

    public AppActivityDetailVo() {
    }

    public AppActivityDetailVo(Integer id, String title, String content, String location, Date activityStartTime, Date activityEndTime, Date registrationStartTime, Date registrationEndTime, Integer countRegistration, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headImgURls) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.location = location;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.countRegistration = countRegistration;
        this.imgUrls = imgUrls;
        this.headImgURls = headImgURls;
    }
}
