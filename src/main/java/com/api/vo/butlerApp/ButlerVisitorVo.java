package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 访客管理Vo list 显示
 */
public class ButlerVisitorVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 访问房产名称
     */
    private String roomName;
    /**
     * 访客名称
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
    /**
     * 实际到访时间
     */
    private Date visitDate;
    /**
     * 访客状态(1.未到，2.已到,【3】.已过期(此状态3数据库不录入，需要根据1.未到和有效时间判断)，4.作废)
     */
    private Integer visitorStatus;

    @Override
    public String toString() {
        return "ButlerVisitorVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", isDrive=" + isDrive +
                ", carNum='" + carNum + '\'' +
                ", effectiveTime=" + effectiveTime +
                ", visitDate=" + visitDate +
                ", visitorStatus=" + visitorStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public ButlerVisitorVo() {
    }

    public ButlerVisitorVo(Integer id, String roomName, String name, Integer isDrive, String carNum, Date effectiveTime, Date visitDate, Integer visitorStatus) {
        this.id = id;
        this.roomName = roomName;
        this.name = name;
        this.isDrive = isDrive;
        this.carNum = carNum;
        this.effectiveTime = effectiveTime;
        this.visitDate = visitDate;
        this.visitorStatus = visitorStatus;
    }
}
