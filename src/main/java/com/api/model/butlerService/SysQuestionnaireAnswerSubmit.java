package com.api.model.butlerService;

import java.util.List;

/**
 * 问卷调查题目提交答案
 */
public class SysQuestionnaireAnswerSubmit {
    /**
     * 题目主键id
     */
    private Integer topicId;
    /**
     * 选择项答案（1.单选,2.多选,3.下拉单选,4.判断题）
     */
    private List<Integer> choiceAnswer;
    /**
     * 简答题答案（5.开放题）
     */
    private String shortAnswer;

    @Override
    public String toString() {
        return "SysQuestionnaireAnswerSubmit{" +
                "topicId=" + topicId +
                ", choiceAnswer=" + choiceAnswer +
                ", shortAnswer='" + shortAnswer + '\'' +
                '}';
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public List<Integer> getChoiceAnswer() {
        return choiceAnswer;
    }

    public void setChoiceAnswer(List<Integer> choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
    }

    public String getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(String shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    public SysQuestionnaireAnswerSubmit() {
    }

    public SysQuestionnaireAnswerSubmit(Integer topicId, List<Integer> choiceAnswer, String shortAnswer) {
        this.topicId = topicId;
        this.choiceAnswer = choiceAnswer;
        this.shortAnswer = shortAnswer;
    }
}
