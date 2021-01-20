package com.api.model.app;

import java.util.Date;

/**
 * app报事报修评论信息
 */
public class AppRepairEvaluate {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 报事报修主键id
     */
    private Integer repairId;
    /**
     * 评价打分（1-10）
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
        return "AppRepairEvaluate{" +
                "id=" + id +
                ", repairId=" + repairId +
                ", evaluationLevel=" + evaluationLevel +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationDate=" + evaluationDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
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

    public AppRepairEvaluate() {
    }

    public AppRepairEvaluate(Integer id, Integer repairId, Integer evaluationLevel, String evaluationContent, Date evaluationDate) {
        this.id = id;
        this.repairId = repairId;
        this.evaluationLevel = evaluationLevel;
        this.evaluationContent = evaluationContent;
        this.evaluationDate = evaluationDate;
    }
}
