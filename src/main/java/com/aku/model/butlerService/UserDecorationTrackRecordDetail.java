package com.aku.model.butlerService;

/**
 * 装修跟踪记录明细表
 */
public class UserDecorationTrackRecordDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修跟踪记录id
     */
    private Integer decorationTrack;
    /**
     * 跟踪检查类型（1.电路，2.水路，3.墙面，4.门窗，5.安防）
     */
    private Integer review;
    /**
     * 是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;
    /**
     * 创建人（业主，物业，装修公司）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Integer createDate;

    @Override
    public String toString() {
        return "UserDecorationTrackRecordDetail{" +
                "id=" + id +
                ", decorationTrack=" + decorationTrack +
                ", review=" + review +
                ", isQualified=" + isQualified +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationTrack() {
        return decorationTrack;
    }

    public void setDecorationTrack(Integer decorationTrack) {
        this.decorationTrack = decorationTrack;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public UserDecorationTrackRecordDetail() {
    }

    public UserDecorationTrackRecordDetail(Integer id, Integer decorationTrack, Integer review, Integer isQualified, Integer createId, Integer createDate) {
        this.id = id;
        this.decorationTrack = decorationTrack;
        this.review = review;
        this.isQualified = isQualified;
        this.createId = createId;
        this.createDate = createDate;
    }
}
