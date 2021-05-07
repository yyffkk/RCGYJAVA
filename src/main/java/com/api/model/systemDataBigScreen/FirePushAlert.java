package com.api.model.systemDataBigScreen;

import java.util.Date;

/**
 * 火灾推送通知内容
 */
public class FirePushAlert {
    /**
     * 设备号
     */
    private String deviceNo;
    /**
     * 报警号
     */
    private String alarmNo;
    /**
     * 数值报警，还是状态报警
     * (C:数值报警，X:状态报警)
     */
    private String alarmType;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 报警时间
     */
    private Date time;

    @Override
    public String toString() {
        return "FirePushAlert{" +
                "deviceNo='" + deviceNo + '\'' +
                ", alarmNo='" + alarmNo + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", time=" + time +
                '}';
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getAlarmNo() {
        return alarmNo;
    }

    public void setAlarmNo(String alarmNo) {
        this.alarmNo = alarmNo;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public FirePushAlert() {
    }

    public FirePushAlert(String deviceNo, String alarmNo, String alarmType, String deviceName, Date time) {
        this.deviceNo = deviceNo;
        this.alarmNo = alarmNo;
        this.alarmType = alarmType;
        this.deviceName = deviceName;
        this.time = time;
    }
}
