package com.aku.vo.butlerService;

/**
 * 跟踪检查记录明细表Vo 回显list
 */
public class VoUserDecorationTrackRecordDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 跟踪检查类型（1.电路，2.水路，3.墙面，4.门窗，5.安防）
     */
    private Integer review;
    /**
     * 是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;

    @Override
    public String toString() {
        return "VoUserDecorationTrackRecordDetail{" +
                "id=" + id +
                ", review=" + review +
                ", isQualified=" + isQualified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public VoUserDecorationTrackRecordDetail() {
    }

    public VoUserDecorationTrackRecordDetail(Integer id, Integer review, Integer isQualified) {
        this.id = id;
        this.review = review;
        this.isQualified = isQualified;
    }
}
