package com.api.vo.app;

import java.util.Date;

/**
 * app 设施预约时段Vo list 回显
 */
public class AppAppointmentDateVo {
    /**
     * 设施预约主键id
     */
    private Integer id;
    /**
     * 预约开始时间
     */
    private Date appointmentStartDate;
    /**
     * 预约结束时间
     */
    private Date appointmentEndDate;
    /**
     * 预约人名称
     */
    private String appointmentName;

    @Override
    public String toString() {
        return "AppAppointmentDateVo{" +
                "id=" + id +
                ", appointmentStartDate=" + appointmentStartDate +
                ", appointmentEndDate=" + appointmentEndDate +
                ", appointmentName='" + appointmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public AppAppointmentDateVo() {
    }

    public AppAppointmentDateVo(Integer id, Date appointmentStartDate, Date appointmentEndDate, String appointmentName) {
        this.id = id;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.appointmentName = appointmentName;
    }
}
