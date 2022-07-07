package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 考勤请假/加班申请记录Vo list 回显
 */
public class VoAttendanceLeaveRecord {
    /**
     * 请假/加班申请记录主键id
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
     * 申请人名称
     */
    private String createName;
    /**
     * 申请人手机号
     */
    private String createTel;
    /**
     * 申请时间
     */
    private Date createDate;
    /**
     * 审核人名称
     */
    private String reviewerName;
    /**
     * 审核时间
     */
    private Date reviewerDate;

    @Override
    public String toString() {
        return "VoAttendanceLeaveRecord{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createName='" + createName + '\'' +
                ", createTel='" + createTel + '\'' +
                ", createDate=" + createDate +
                ", reviewerName='" + reviewerName + '\'' +
                ", reviewerDate=" + reviewerDate +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTel() {
        return createTel;
    }

    public void setCreateTel(String createTel) {
        this.createTel = createTel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Date getReviewerDate() {
        return reviewerDate;
    }

    public void setReviewerDate(Date reviewerDate) {
        this.reviewerDate = reviewerDate;
    }

    public VoAttendanceLeaveRecord() {
    }

    public VoAttendanceLeaveRecord(Integer id, String reason, Integer status, Integer type, Date startDate, Date endDate, String createName, String createTel, Date createDate, String reviewerName, Date reviewerDate) {
        this.id = id;
        this.reason = reason;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createName = createName;
        this.createTel = createTel;
        this.createDate = createDate;
        this.reviewerName = reviewerName;
        this.reviewerDate = reviewerDate;
    }
}
