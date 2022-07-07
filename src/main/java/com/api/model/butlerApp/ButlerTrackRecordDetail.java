package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 跟踪记录信息详情
 */
public class ButlerTrackRecordDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修跟踪记录id
     */
    private Integer decorationTrackRecordId;
    /**
     * 跟踪检查内容id（1.电路，2.水路，3.墙面，4.门窗，5.安防）【装修检查内容表】
     */
    private Integer decorationTrackChecksContentId;
    /**
     * 是否合格（1.正常，0.异常）
     */
    private Integer isQualified;
    /**
     * 创建人（物业表）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerTrackRecordDetail{" +
                "id=" + id +
                ", decorationTrackRecordId=" + decorationTrackRecordId +
                ", decorationTrackChecksContentId=" + decorationTrackChecksContentId +
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

    public Integer getDecorationTrackRecordId() {
        return decorationTrackRecordId;
    }

    public void setDecorationTrackRecordId(Integer decorationTrackRecordId) {
        this.decorationTrackRecordId = decorationTrackRecordId;
    }

    public Integer getDecorationTrackChecksContentId() {
        return decorationTrackChecksContentId;
    }

    public void setDecorationTrackChecksContentId(Integer decorationTrackChecksContentId) {
        this.decorationTrackChecksContentId = decorationTrackChecksContentId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerTrackRecordDetail() {
    }

    public ButlerTrackRecordDetail(Integer id, Integer decorationTrackRecordId, Integer decorationTrackChecksContentId, Integer isQualified, Integer createId, Date createDate) {
        this.id = id;
        this.decorationTrackRecordId = decorationTrackRecordId;
        this.decorationTrackChecksContentId = decorationTrackChecksContentId;
        this.isQualified = isQualified;
        this.createId = createId;
        this.createDate = createDate;
    }
}
