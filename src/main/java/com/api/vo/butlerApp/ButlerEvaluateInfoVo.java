package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 评价信息Vo list 回显
 */
public class ButlerEvaluateInfoVo {
    /**
     * 评价打分 1-10
     */
    private Integer evaluationLevel;
    /**
     * 评价内容
     */
    private String evaluationContent;
    /**
     * 评价时间
     */
    private Date evaluationDate;

    @Override
    public String toString() {
        return "ButlerEvaluateInfoVo{" +
                "evaluationLevel=" + evaluationLevel +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationDate=" + evaluationDate +
                '}';
    }

    public Integer getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(Integer evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public ButlerEvaluateInfoVo() {
    }

    public ButlerEvaluateInfoVo(Integer evaluationLevel, String evaluationContent, Date evaluationDate) {
        this.evaluationLevel = evaluationLevel;
        this.evaluationContent = evaluationContent;
        this.evaluationDate = evaluationDate;
    }
}
