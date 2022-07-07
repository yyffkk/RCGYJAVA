package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app社区活动Vo list 回显
 */
public class AppActivityVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 状态：1.未开始，2.进行中，3.已结束，4.已投票
     */
    private Integer status;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名结束时间
     */
    private Date registrationEndTime;
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
        return "AppActivityVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public AppActivityVo() {
    }

    public AppActivityVo(Integer id, String title, String location, Integer status, Date registrationStartTime, Date registrationEndTime, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headImgURls) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.status = status;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.imgUrls = imgUrls;
        this.headImgURls = headImgURls;
    }
}
