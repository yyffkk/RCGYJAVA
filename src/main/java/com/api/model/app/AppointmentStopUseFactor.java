package com.api.model.app;

import java.util.Date;

/**
 * 设施预约结束使用条件
 */
public class AppointmentStopUseFactor {
    /**
     * 设施预约主键ID
     */
    private Integer facilitiesAppointmentId;
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 使用结束时间
     */
    private Date useEndDate;

    @Override
    public String toString() {
        return "AppointmentStopUseFactor{" +
                "facilitiesAppointmentId=" + facilitiesAppointmentId +
                ", id=" + id +
                ", useEndDate=" + useEndDate +
                '}';
    }

    public Integer getFacilitiesAppointmentId() {
        return facilitiesAppointmentId;
    }

    public void setFacilitiesAppointmentId(Integer facilitiesAppointmentId) {
        this.facilitiesAppointmentId = facilitiesAppointmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    public AppointmentStopUseFactor() {
    }

    public AppointmentStopUseFactor(Integer facilitiesAppointmentId, Integer id, Date useEndDate) {
        this.facilitiesAppointmentId = facilitiesAppointmentId;
        this.id = id;
        this.useEndDate = useEndDate;
    }
}
