package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 装修信息 Vo list
 */
public class VoDecoration {
    /**
     * 装修主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 业主姓名
     */
    private String residentName;
    /**
     * 业主手机号
     */
    private String residentTel;
    /**
     * 装修负责人
     */
    private String name;
    /**
     * 负责人手机号
     */
    private String tel;
    /**
     * 装修车辆车牌号
     */
    private String carCode;
    /**
     * 装修起始时间
     */
    private Date effectiveTimeStart;
    /**
     * 装修预计终止时间
     */
    private Date effectiveTimeEnd;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 楼栋编号
     */
    private Integer estateNo;

    @Override
    public String toString() {
        return "VoDecoration{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", carCode='" + carCode + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getEstateNo() {
        return estateNo;
    }

    public void setEstateNo(Integer estateNo) {
        this.estateNo = estateNo;
    }

    public VoDecoration() {
    }

    public VoDecoration(Integer id, String roomName, Integer status, String residentName, String residentTel, String name, String tel, String carCode, Date effectiveTimeStart, Date effectiveTimeEnd, String roomNumber, Integer unitNo, Integer estateNo) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.name = name;
        this.tel = tel;
        this.carCode = carCode;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
