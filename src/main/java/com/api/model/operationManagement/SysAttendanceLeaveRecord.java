package com.api.model.operationManagement;

import java.util.Date;

/**
 * 考勤请假/加班记录model
 */
public class SysAttendanceLeaveRecord {
    /**
     * 请假/加班记录主键id
     */
    private Integer id;
    /**
     * 请假/加班原因
     */
    private String reason;
    /**
     * 状态：1.待审核，2.审核通过，3.审核驳回
     */
    private Integer status;
    /**
     * 类型：1.请假，2.加班
     */
    private Integer type;
    /**
     * 请假/加班开始时间
     */
    private Date startDate;
    /**
     * 请假/加班结束时间
     */
    private Date endDate;
    /**
     * 审核人id
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date reviewerDate;
    /**
     * 创建人（申请人）
     */
    private Integer createId;
    /**
     * 创建时间（申请时间）
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysAttendanceLeaveRecord{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reviewer=" + reviewer +
                ", reviewerDate=" + reviewerDate +
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getReviewerDate() {
        return reviewerDate;
    }

    public void setReviewerDate(Date reviewerDate) {
        this.reviewerDate = reviewerDate;
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

    public SysAttendanceLeaveRecord() {
    }

    public SysAttendanceLeaveRecord(Integer id, String reason, Integer status, Integer type, Date startDate, Date endDate, Integer reviewer, Date reviewerDate, Integer createId, Date createDate) {
        this.id = id;
        this.reason = reason;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reviewer = reviewer;
        this.reviewerDate = reviewerDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
