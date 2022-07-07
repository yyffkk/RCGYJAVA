package com.api.vo.butlerService;

import java.util.Date;

/**
 * 咨询建议表 Vo list
 */
public class VoUserAdvice {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 咨询建议内容
     */
    private String content;
    /**
     * 类型 1.咨询，2.建议,3.投诉,4.表扬
     */
    private Integer type;
    /**
     * 发布人姓名
     */
    private String releaseName;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 状态（查询是否有反馈信息）(1.未反馈，2.反馈中，3.已反馈)
     */
    private Integer status;
    /**
     * 评分数1-10分
     */
    private Integer score;
    /**
     * 最后一次回复/提问时间（最后一次反馈时间）
     */
    private Date lastFeedBackDate;

    @Override
    public String toString() {
        return "VoUserAdvice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", releaseName='" + releaseName + '\'' +
                ", releaseDate=" + releaseDate +
                ", status=" + status +
                ", score=" + score +
                ", lastFeedBackDate=" + lastFeedBackDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getLastFeedBackDate() {
        return lastFeedBackDate;
    }

    public void setLastFeedBackDate(Date lastFeedBackDate) {
        this.lastFeedBackDate = lastFeedBackDate;
    }

    public VoUserAdvice() {
    }

    public VoUserAdvice(Integer id, String content, Integer type, String releaseName, Date releaseDate, Integer status, Integer score, Date lastFeedBackDate) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.releaseName = releaseName;
        this.releaseDate = releaseDate;
        this.status = status;
        this.score = score;
        this.lastFeedBackDate = lastFeedBackDate;
    }
}
