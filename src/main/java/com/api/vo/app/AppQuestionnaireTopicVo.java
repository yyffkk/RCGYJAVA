package com.api.vo.app;

import java.util.List;

/**
 * app问卷调查题目集合
 */
public class AppQuestionnaireTopicVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 答题类型（1.单选，2.多选，3.下拉单选，4.判断题，5.开放题）
     */
    private Integer type;
    /**
     * 题目
     */
    private String topic;
    /**
     * 选择题选项信息集合（仅选择题需要填写）
     */
    private List<AppQuestionnaireChoiceVo> questionnaireChoiceVoList;

    @Override
    public String toString() {
        return "AppQuestionnaireTopicVo{" +
                "id=" + id +
                ", type=" + type +
                ", topic='" + topic + '\'' +
                ", questionnaireChoiceVoList=" + questionnaireChoiceVoList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<AppQuestionnaireChoiceVo> getQuestionnaireChoiceVoList() {
        return questionnaireChoiceVoList;
    }

    public void setQuestionnaireChoiceVoList(List<AppQuestionnaireChoiceVo> questionnaireChoiceVoList) {
        this.questionnaireChoiceVoList = questionnaireChoiceVoList;
    }

    public AppQuestionnaireTopicVo() {
    }

    public AppQuestionnaireTopicVo(Integer id, Integer type, String topic, List<AppQuestionnaireChoiceVo> questionnaireChoiceVoList) {
        this.id = id;
        this.type = type;
        this.topic = topic;
        this.questionnaireChoiceVoList = questionnaireChoiceVoList;
    }
}
