package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 提交检查信息model
 */
public class ButlerSubmitCheck {
    /**
     * 物品借还管理主键id
     */
    private Integer articleBorrowId;
    /**
     * 物品明细主键id
     */
    private Integer articleDetailId;
    /**
     * 借取状态
     */
    private Integer borrowStatus;
    /**
     * 物品检查状态
     */
    private Integer articleStatus;
    /**
     * 归还时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "ButlerSubmitCheck{" +
                "articleBorrowId=" + articleBorrowId +
                ", articleDetailId=" + articleDetailId +
                ", borrowStatus=" + borrowStatus +
                ", articleStatus=" + articleStatus +
                ", endDate=" + endDate +
                '}';
    }

    public Integer getArticleBorrowId() {
        return articleBorrowId;
    }

    public void setArticleBorrowId(Integer articleBorrowId) {
        this.articleBorrowId = articleBorrowId;
    }

    public Integer getArticleDetailId() {
        return articleDetailId;
    }

    public void setArticleDetailId(Integer articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ButlerSubmitCheck() {
    }

    public ButlerSubmitCheck(Integer articleBorrowId, Integer articleDetailId, Integer borrowStatus, Integer articleStatus, Date endDate) {
        this.articleBorrowId = articleBorrowId;
        this.articleDetailId = articleDetailId;
        this.borrowStatus = borrowStatus;
        this.articleStatus = articleStatus;
        this.endDate = endDate;
    }
}
