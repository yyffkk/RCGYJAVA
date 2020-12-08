package com.api.model.butlerService;

import java.util.Date;

/**
 * 访客管理信息
 */
public class SearchUserVisitors {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋信息 例：1-1-1
     */
    private String roomName;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访客性别
     */
    private Integer sex;
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
     * 访客状态(1.未到，2.已到,3.已过期，4.作废)
     */
    private Integer visitorStatus;
    /**
     * 填写类型(1.业主填写，2.访客填写)
     */
    private Integer type;
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
        return "SearchUserVisitors{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", carNum='" + carNum + '\'' +
                ", expectedVisitDate=" + expectedVisitDate +
                ", visitDate=" + visitDate +
                ", visitorStatus=" + visitorStatus +
                ", type=" + type +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public SearchUserVisitors() {
    }

    public SearchUserVisitors(Integer pageNum, Integer size, Integer id, String roomName, String name, Integer sex, String carNum, Date expectedVisitDate, Date visitDate, Integer visitorStatus, Integer type, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.roomName = roomName;
        this.name = name;
        this.sex = sex;
        this.carNum = carNum;
        this.expectedVisitDate = expectedVisitDate;
        this.visitDate = visitDate;
        this.visitorStatus = visitorStatus;
        this.type = type;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
