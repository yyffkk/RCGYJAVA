package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app问卷调查详情
 */
public class AppQuestionnaireDetailVo {
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
    private List<AppQuestionnaireTopicVo> questionnaireTopicVoList;
    /**
     * 照片路径
     */
    private List<VoResourcesImg> voResourcesImgList;

    @Override
    public String toString() {
        return "AppQuestionnaireDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", questionnaireTopicVoList=" + questionnaireTopicVoList +
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

    public List<AppQuestionnaireTopicVo> getQuestionnaireTopicVoList() {
        return questionnaireTopicVoList;
    }

    public void setQuestionnaireTopicVoList(List<AppQuestionnaireTopicVo> questionnaireTopicVoList) {
        this.questionnaireTopicVoList = questionnaireTopicVoList;
    }

    public List<VoResourcesImg> getVoResourcesImgList() {
        return voResourcesImgList;
    }

    public void setVoResourcesImgList(List<VoResourcesImg> voResourcesImgList) {
        this.voResourcesImgList = voResourcesImgList;
    }

    public AppQuestionnaireDetailVo() {
    }

    public AppQuestionnaireDetailVo(Integer id, String title, String description, Date beginDate, Date endDate, List<AppQuestionnaireTopicVo> questionnaireTopicVoList, List<VoResourcesImg> voResourcesImgList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.questionnaireTopicVoList = questionnaireTopicVoList;
        this.voResourcesImgList = voResourcesImgList;
    }
}
