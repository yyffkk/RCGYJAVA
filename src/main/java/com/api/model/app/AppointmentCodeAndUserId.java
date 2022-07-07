package com.api.model.app;

/**
 * 设施预约编号和用户主键id
 */
public class AppointmentCodeAndUserId {
    /**
     * 设施预约编号
     */
    private String appointmentCode;
    /**
     * 用户主键id
     */
    private String id;

    @Override
    public String toString() {
        return "AppointmentCodeAndUserId{" +
                "appointmentCode='" + appointmentCode + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getAppointmentCode() {
        return appointmentCode;
    }

    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppointmentCodeAndUserId() {
    }

    public AppointmentCodeAndUserId(String appointmentCode, String id) {
        this.appointmentCode = appointmentCode;
        this.id = id;
    }
}
