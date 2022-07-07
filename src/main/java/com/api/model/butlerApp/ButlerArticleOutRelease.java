package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app物品出户 放行model
 */
public class ButlerArticleOutRelease {
    /**
     * 物品出户主键id
     */
    private Integer id;
    /**
     * 实际出门时间
     */
    private Date actualTime;
    /**
     * 出口(1.东门，2.南门，3.西门，4.北门)
     */
    private Integer export;
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;
    /**
     * 审核人（系统用户表）
     */
    private Integer reviewId;
    /**
     * 审核时间
     */
    private Date reviewDate;

    @Override
    public String toString() {
        return "ButlerArticleOutRelease{" +
                "id=" + id +
                ", actualTime=" + actualTime +
                ", export=" + export +
                ", status=" + status +
                ", reviewId=" + reviewId +
                ", reviewDate=" + reviewDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public Integer getExport() {
        return export;
    }

    public void setExport(Integer export) {
        this.export = export;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public ButlerArticleOutRelease() {
    }

    public ButlerArticleOutRelease(Integer id, Date actualTime, Integer export, Integer status, Integer reviewId, Date reviewDate) {
        this.id = id;
        this.actualTime = actualTime;
        this.export = export;
        this.status = status;
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
    }
}
