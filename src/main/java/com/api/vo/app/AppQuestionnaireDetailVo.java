package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

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

    public AppQuestionnaireDetailVo(Integer id, String title, String description, List<AppQuestionnaireTopicVo> questionnaireTopicVoList, List<VoResourcesImg> voResourcesImgList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questionnaireTopicVoList = questionnaireTopicVoList;
        this.voResourcesImgList = voResourcesImgList;
    }
}
