package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 社区公告Vo list 回显
 */
public class ButlerAnnouncementVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 照片资源信息
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerAnnouncementVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseTime=" + releaseTime +
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerAnnouncementVo() {
    }

    public ButlerAnnouncementVo(Integer id, String title, Date releaseTime, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.title = title;
        this.releaseTime = releaseTime;
        this.imgUrls = imgUrls;
    }
}
