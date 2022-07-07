package com.api.vo.butlerService;

import java.util.Date;

/**
 * 访客管理Vo 回显list
 */
public class VoUserVisitors {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋信息 例：1-1-1
     */
    private String roomName;
    /**
     * 填写类型(1.业主填写，2.访客填写)
     */
    private Integer type;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 是否开车
     */
    private Integer isDrive;
    /**
     * 车牌号
     */
    private String carNum;
    /**
     * 预计到访时间
     */
    private Date expectedVisitDate;
    /**
     * 实际到访时间
     */
    private Date visitDate;
    /**
     * 实际离开时间（最后一次离开时间）
     */
    private Date departureTime;
    /**
     * 有效时间
     */
    private Date effectiveTime;
    /**
     * 访客状态(1.未到，2.已到,3.已过期，4.作废)
     */
    private Integer visitorStatus;
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
        return "VoUserVisitors{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", isDrive=" + isDrive +
                ", carNum='" + carNum + '\'' +
                ", expectedVisitDate=" + expectedVisitDate +
                ", visitDate=" + visitDate +
                ", departureTime=" + departureTime +
                ", effectiveTime=" + effectiveTime +
                ", visitorStatus=" + visitorStatus +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Date getExpectedVisitDate() {
        return expectedVisitDate;
    }

    public void setExpectedVisitDate(Date expectedVisitDate) {
        this.expectedVisitDate = expectedVisitDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
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

    public VoUserVisitors() {
    }

    public VoUserVisitors(Integer id, String roomName, Integer type, String name, String tel, Integer sex, Integer isDrive, String carNum, Date expectedVisitDate, Date visitDate, Date departureTime, Date effectiveTime, Integer visitorStatus, String roomNumber, Integer unitNo, Integer estateNo) {
        this.id = id;
        this.roomName = roomName;
        this.type = type;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.isDrive = isDrive;
        this.carNum = carNum;
        this.expectedVisitDate = expectedVisitDate;
        this.visitDate = visitDate;
        this.departureTime = departureTime;
        this.effectiveTime = effectiveTime;
        this.visitorStatus = visitorStatus;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
