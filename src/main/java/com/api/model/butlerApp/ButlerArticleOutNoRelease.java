package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 物品出户 不放行model
 */
public class ButlerArticleOutNoRelease {
    /**
     * 物品出户主键id
     */
    private Integer id;
    /**
     * 备注（不放行理由，驳回申请时使用）
     */
    private String remarks;
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
        return "ButlerArticleOutNoRelease{" +
                "id=" + id +
                ", remarks='" + remarks + '\'' +
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public ButlerArticleOutNoRelease() {
    }

    public ButlerArticleOutNoRelease(Integer id, String remarks, Integer status, Integer reviewId, Date reviewDate) {
        this.id = id;
        this.remarks = remarks;
        this.status = status;
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
    }
}
