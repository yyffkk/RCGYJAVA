package com.api.vo.app;

import java.util.Date;

/**
 * app 设施预约 Vo list 回显
 */
public class AppFacilitiesAppointmentVo {
    /**
     * 设施预约主键id
     */
    private Integer id;
    /**
     * 预约编号
     */
    private String code;
    /**
     * 设施名称
     */
    private String facilitiesName;
    /**
     * 预约状态（1.未签到(预约时间前30分钟显示扫码签到，之前为取消预约)，2.已签到，3.已作废，4.已取消,5.已结束）
     */
    private Integer status;
    /**
     * 设施地址
     */
    private String address;
    /**
     * 预约开始时间
     */
    private Date appointmentStartDate;
    /**
     * 预约结束时间
     */
    private Date appointmentEndDate;
    /**
     * 作废原因
     */
    private String nullifyReason;
    /**
     * 使用结束时间（当状态为2.已签到，该值为null，则取预约结束时间 为 使用结束时间）
     */
    private Date useEndDate;

    @Override
    public String toString() {
        return "AppFacilitiesAppointmentVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesName='" + facilitiesName + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", appointmentStartDate=" + appointmentStartDate +
                ", appointmentEndDate=" + appointmentEndDate +
                ", nullifyReason='" + nullifyReason + '\'' +
                ", useEndDate=" + useEndDate +
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

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getNullifyReason() {
        return nullifyReason;
    }

    public void setNullifyReason(String nullifyReason) {
        this.nullifyReason = nullifyReason;
    }

    public Date getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    public AppFacilitiesAppointmentVo() {
    }

    public AppFacilitiesAppointmentVo(Integer id, String code, String facilitiesName, Integer status, String address, Date appointmentStartDate, Date appointmentEndDate, String nullifyReason, Date useEndDate) {
        this.id = id;
        this.code = code;
        this.facilitiesName = facilitiesName;
        this.status = status;
        this.address = address;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.nullifyReason = nullifyReason;
        this.useEndDate = useEndDate;
    }
}
