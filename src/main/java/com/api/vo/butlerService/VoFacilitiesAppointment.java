package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施预约Vo list 回显
 */
public class VoFacilitiesAppointment {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 预约编号
     */
    private String code;
    /**
     * 设施分类名称
     */
    private String facilitiesCategoryName;
    /**
     * 设施名称
     */
    private String facilitiesName;
    /**
     * 预约人
     */
    private String appointmentName;
    /**
     * 预约人电话
     */
    private String appointmentTel;
    /**
     * 预约开始时间
     */
    private Date appointmentStartDate;
    /**
     * 预约结束时间
     */
    private Date appointmentEndDate;
    /**
     * 预约状态（1.未签到，2.已签到，3.已作废，4.已取消,5.已结束）
     */
    private Integer status;
    /**
     * 创建时间【申请时间】
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesAppointment{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesCategoryName='" + facilitiesCategoryName + '\'' +
                ", facilitiesName='" + facilitiesName + '\'' +
                ", appointmentName='" + appointmentName + '\'' +
                ", appointmentTel='" + appointmentTel + '\'' +
                ", appointmentStartDate=" + appointmentStartDate +
                ", appointmentEndDate=" + appointmentEndDate +
                ", status=" + status +
                ", createDate=" + createDate +
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

    public String getFacilitiesCategoryName() {
        return facilitiesCategoryName;
    }

    public void setFacilitiesCategoryName(String facilitiesCategoryName) {
        this.facilitiesCategoryName = facilitiesCategoryName;
    }

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public String getAppointmentTel() {
        return appointmentTel;
    }

    public void setAppointmentTel(String appointmentTel) {
        this.appointmentTel = appointmentTel;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFacilitiesAppointment() {
    }

    public VoFacilitiesAppointment(Integer id, String code, String facilitiesCategoryName, String facilitiesName, String appointmentName, String appointmentTel, Date appointmentStartDate, Date appointmentEndDate, Integer status, Date createDate) {
        this.id = id;
        this.code = code;
        this.facilitiesCategoryName = facilitiesCategoryName;
        this.facilitiesName = facilitiesName;
        this.appointmentName = appointmentName;
        this.appointmentTel = appointmentTel;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.status = status;
        this.createDate = createDate;
    }
}
