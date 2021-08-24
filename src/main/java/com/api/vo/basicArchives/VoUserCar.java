package com.api.vo.basicArchives;

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
     * 车辆类型（1.私家车，2.货车，3.大巴，4.牵引汽车，5.其他）
     */
    private Integer type;
    /**
     * 车辆品牌
     */
    private String brand;
    /**
     * 车辆型号
     */
    private String model;
    /**
     * 车辆颜色(1.红，2.橙，3.黄，4.绿，5.青，6.蓝，7紫，8.黑，9.白，10.灰，11.金，12.磨砂，13.其他)
     */
    private Integer color;
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
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
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

    public VoUserCar(Integer id, String code, String owner, String tel, Integer status, Long remainingTime, String parkingSpaceCode, String roomName, Integer idType, String idNumber, Integer type, String brand, String model, Integer color, Date effectiveTimeStart, Date effectiveTimeEnd) {
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
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
