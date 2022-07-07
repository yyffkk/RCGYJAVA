package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施预约管理model
 */
public class FacilitiesAppointment {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 预约编号
     */
    private String code;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 设施主键id
     */
    private Integer facilitiesManageId;
    /**
     * 预约状态（1.未签到，2.已签到，3.已作废，4.已取消,5.已结束）
     */
    private Integer status;
    /**
     * 预约人id
     */
    private Integer appointmentId;
    /**
     * 预约开始时间
     */
    private Date appointmentStartDate;
    /**
     * 预约结束时间
     */
    private Date appointmentEndDate;
    /**
     * 创建人（-1：app创建，正数：物业人员主键id）
     */
    private Integer createId;
    /**
     * 创建时间【申请时间】
     */
    private Date createDate;
    /**
     * 用户反馈内容
     */
    private String feedback;
    /**
     * 作废原因
     */
    private String nullifyReason;

    @Override
    public String toString() {
        return "FacilitiesAppointment{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", estateId=" + estateId +
                ", facilitiesManageId=" + facilitiesManageId +
                ", status=" + status +
                ", appointmentId=" + appointmentId +
                ", appointmentStartDate=" + appointmentStartDate +
                ", appointmentEndDate=" + appointmentEndDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", feedback='" + feedback + '\'' +
                ", nullifyReason='" + nullifyReason + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getFacilitiesManageId() {
        return facilitiesManageId;
    }

    public void setFacilitiesManageId(Integer facilitiesManageId) {
        this.facilitiesManageId = facilitiesManageId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentStartDate() {
        return appointmentStartDate;
    }

    public void setAppointmentStartDate(Date appointmentStartDate) {
        this.appointmentStartDate = appointmentStartDate;
    }

    public Date getAppointmentEndDate() {
        return appointmentEndDate;
    }

    public void setAppointmentEndDate(Date appointmentEndDate) {
        this.appointmentEndDate = appointmentEndDate;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getNullifyReason() {
        return nullifyReason;
    }

    public void setNullifyReason(String nullifyReason) {
        this.nullifyReason = nullifyReason;
    }

    public FacilitiesAppointment() {
    }

    public FacilitiesAppointment(Integer id, String code, Integer estateId, Integer facilitiesManageId, Integer status, Integer appointmentId, Date appointmentStartDate, Date appointmentEndDate, Integer createId, Date createDate, String feedback, String nullifyReason) {
        this.id = id;
        this.code = code;
        this.estateId = estateId;
        this.facilitiesManageId = facilitiesManageId;
        this.status = status;
        this.appointmentId = appointmentId;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.createId = createId;
        this.createDate = createDate;
        this.feedback = feedback;
        this.nullifyReason = nullifyReason;
    }
}
