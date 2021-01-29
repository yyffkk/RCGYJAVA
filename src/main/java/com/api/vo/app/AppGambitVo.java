package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * app话题信息Vo list 回显
 */
public class AppGambitVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 话题照片资源
     */
    private List<VoResourcesImg> imgUrl;
    /**
     * 热度（活跃度）
     */
    private Integer activityNum;

    @Override
    public String toString() {
        return "AppGambitVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl=" + imgUrl +
                ", activityNum=" + activityNum +
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public AppGambitVo() {
    }

    public AppGambitVo(Integer id, String title, String summary, String content, List<VoResourcesImg> imgUrl, Integer activityNum) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.imgUrl = imgUrl;
        this.activityNum = activityNum;
    }
}
