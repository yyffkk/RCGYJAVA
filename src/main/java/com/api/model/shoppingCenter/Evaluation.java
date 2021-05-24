package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 评价model
 */
public class Evaluation {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 商品预约主键id
     */
    private Integer goodsAppointmentId;
    /**
     * 评分数1-10分
     */
    private Integer score;
    /**
     * 评价时间
     */
    private Date evaluationDate;
    /**
     * 评价原因
     */
    private String evaluationReason;

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", goodsAppointmentId=" + goodsAppointmentId +
                ", score=" + score +
                ", evaluationDate=" + evaluationDate +
                ", evaluationReason='" + evaluationReason + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsAppointmentId() {
        return goodsAppointmentId;
    }

    public void setGoodsAppointmentId(Integer goodsAppointmentId) {
        this.goodsAppointmentId = goodsAppointmentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getEvaluationReason() {
        return evaluationReason;
    }

    public void setEvaluationReason(String evaluationReason) {
        this.evaluationReason = evaluationReason;
    }

    public Evaluation() {
    }

    public Evaluation(Integer id, Integer goodsAppointmentId, Integer score, Date evaluationDate, String evaluationReason) {
        this.id = id;
        this.goodsAppointmentId = goodsAppointmentId;
        this.score = score;
        this.evaluationDate = evaluationDate;
        this.evaluationReason = evaluationReason;
    }
}
