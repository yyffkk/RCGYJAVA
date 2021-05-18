package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 火灾报警Vo list 回显
 */
public class VoFireAlarm {
    /**
     * 主键id
     */
    private Integer id;
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
    private Date alarmTime;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFireAlarm{" +
                "id=" + id +
                ", deviceNo='" + deviceNo + '\'' +
                ", alarmNo='" + alarmNo + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", alarmTime=" + alarmTime +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFireAlarm() {
    }

    public VoFireAlarm(Integer id, String deviceNo, String alarmNo, String alarmType, String deviceName, Date alarmTime, Date createDate) {
        this.id = id;
        this.deviceNo = deviceNo;
        this.alarmNo = alarmNo;
        this.alarmType = alarmType;
        this.deviceName = deviceName;
        this.alarmTime = alarmTime;
        this.createDate = createDate;
    }
}
