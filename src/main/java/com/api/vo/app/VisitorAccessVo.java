package com.api.vo.app;

import java.util.Date;

/**
 * 访客通行信息Vo list
 */
public class VisitorAccessVo {
    /**
     * 访客主键id
     */
    private Integer id;
    /**
     * 通行证认证码
     */
    private Long accessCode;
    /**
     * 访客状态(1.未到，2.已到,3.已过期，4.作废)
     */
    private Integer visitorStatus;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 是否开车(1.开车，0.不开车)
     */
    private Integer isDrive;
    /**
     * 车牌号
     */
    private String carNum;
    /**
     * 有效时间
     */
    private Date effectiveTime;

    @Override
    public String toString() {
        return "VisitorAccessVo{" +
                "id=" + id +
                ", accessCode=" + accessCode +
                ", visitorStatus=" + visitorStatus +
                ", name='" + name + '\'' +
                ", isDrive=" + isDrive +
                ", carNum='" + carNum + '\'' +
                ", effectiveTime=" + effectiveTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Long accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDrive() {
        return isDrive;
    }

    public void setIsDrive(Integer isDrive) {
        this.isDrive = isDrive;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public VisitorAccessVo() {
    }

    public VisitorAccessVo(Integer id, Long accessCode, Integer visitorStatus, String name, Integer isDrive, String carNum, Date effectiveTime) {
        this.id = id;
        this.accessCode = accessCode;
        this.visitorStatus = visitorStatus;
        this.name = name;
        this.isDrive = isDrive;
        this.carNum = carNum;
        this.effectiveTime = effectiveTime;
    }
}
