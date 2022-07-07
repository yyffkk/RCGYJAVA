package com.api.model.basicArchives;

import java.util.Arrays;
import java.util.Date;

/**
 * 审核操作内容
 */
public class Review {
    /**
     * 审核管理主键id
     */
    private Integer id;
    /**
     * 审核状态，1.通过，2.不通过
     */
    private Integer status;
    /**
     * 备注
     */
    private String remakes;
    /**
     * 审核时间
     */
    private Date reviewerDate;
    /**
     * 审核相关照片
     */
    private String[] reviewFiles;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", status=" + status +
                ", remakes='" + remakes + '\'' +
                ", reviewerDate=" + reviewerDate +
                ", reviewFiles=" + Arrays.toString(reviewFiles) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public Date getReviewerDate() {
        return reviewerDate;
    }

    public void setReviewerDate(Date reviewerDate) {
        this.reviewerDate = reviewerDate;
    }

    public String[] getReviewFiles() {
        return reviewFiles;
    }

    public void setReviewFiles(String[] reviewFiles) {
        this.reviewFiles = reviewFiles;
    }

    public Review() {
    }

    public Review(Integer id, Integer status, String remakes, Date reviewerDate, String[] reviewFiles) {
        this.id = id;
        this.status = status;
        this.remakes = remakes;
        this.reviewerDate = reviewerDate;
        this.reviewFiles = reviewFiles;
    }
}
