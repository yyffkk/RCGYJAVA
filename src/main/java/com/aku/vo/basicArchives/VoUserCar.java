package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 车辆信息Vo   list
 */
public class VoUserCar {
    /**
     * 车辆主键id
     */
    private Integer id;
    /**
     * 车辆编号
     */
    private String code;
    /**
     * 车主姓名
     */
    private String owner;
    /**
     * 车主手机号
     */
    private String tel;
    /**
     * 车辆状态
     */
    private Integer status;
    /**
     * 车辆 停置剩余时间（仅限 包月，包年）
     */
    private Long remainingTime;
    /**
     * 车位编号
     */
    private String parkingSpaceCode;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 有效时间开始（仅限包年，包月）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（仅限包年，包月）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "VoUserCar{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", owner='" + owner + '\'' +
                ", tel='" + tel + '\'' +
                ", status=" + status +
                ", remainingTime=" + remainingTime +
                ", parkingSpaceCode='" + parkingSpaceCode + '\'' +
                ", roomName='" + roomName + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(Long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getParkingSpaceCode() {
        return parkingSpaceCode;
    }

    public void setParkingSpaceCode(String parkingSpaceCode) {
        this.parkingSpaceCode = parkingSpaceCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public VoUserCar() {
    }

    public VoUserCar(Integer id, String code, String owner, String tel, Integer status, Long remainingTime, String parkingSpaceCode, String roomName, Integer idType, String idNumber, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.code = code;
        this.owner = owner;
        this.tel = tel;
        this.status = status;
        this.remainingTime = remainingTime;
        this.parkingSpaceCode = parkingSpaceCode;
        this.roomName = roomName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
