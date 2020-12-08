package com.api.vo.butlerService;


import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 问卷调查表信息 findById 回显
 */
public class VoFindByIdQuestionnaire {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 问卷标题
     */
    private String title;
    /**
     * 问卷说明
     */
    private String description;
    /**
     * 答题人员类型(1.无限制，2.业主，3.租客)
     */
    private Integer answerType;
    /**
     * 答题开始时间
     */
    private Date beginDate;
    /**
     * 答题结束时间
     */
    private Date endDate;
    /**
     * 题目信息集合
     */
    private List<VoFindByIdTopic> voFindByIdTopicList;
    /**
     * 是否发布（默认未发布）（1.发布，0.未发布）
     */
    private Integer isRelease;
    /**
     * 照片路径
     */
    private List<VoResourcesImg> voResourcesImgList;

    @Override
    public String toString() {
        return "VoFindByIdQuestionnaire{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", answerType=" + answerType +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", voFindByIdTopicList=" + voFindByIdTopicList +
                ", isRelease=" + isRelease +
                ", voResourcesImgList=" + voResourcesImgList +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<VoFindByIdTopic> getVoFindByIdTopicList() {
        return voFindByIdTopicList;
    }

    public void setVoFindByIdTopicList(List<VoFindByIdTopic> voFindByIdTopicList) {
        this.voFindByIdTopicList = voFindByIdTopicList;
    }

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public List<VoResourcesImg> getVoResourcesImgList() {
        return voResourcesImgList;
    }

    public void setVoResourcesImgList(List<VoResourcesImg> voResourcesImgList) {
        this.voResourcesImgList = voResourcesImgList;
    }

    public VoFindByIdQuestionnaire() {
    }

    public VoFindByIdQuestionnaire(Integer id, String title, String description, Integer answerType, Date beginDate, Date endDate, List<VoFindByIdTopic> voFindByIdTopicList, Integer isRelease, List<VoResourcesImg> voResourcesImgList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answerType = answerType;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.voFindByIdTopicList = voFindByIdTopicList;
        this.isRelease = isRelease;
        this.voResourcesImgList = voResourcesImgList;
    }
}
