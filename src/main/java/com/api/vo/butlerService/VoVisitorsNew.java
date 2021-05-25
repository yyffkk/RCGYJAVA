package com.api.vo.butlerService;

import java.util.Date;

/**
 * 新版访客信息Vo list 回显
 */
public class VoVisitorsNew {
    /**
     * 新版访客信息主键id
     */
    private Integer id;
    /**
     * 拜访房屋名称
     */
    private String roomName;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访客手机号
     */
    private String tel;
    /**
     * 访客性别，1.男，2.女
     */
    private Integer sex;
    /**
     * 访客车牌号（选填）
     */
    private String carNumber;
    /**
     * 预计到访时间开始
     */
    private Date visitDateStart;
    /**
     * 预计到访时间结束
     */
    private Date visitDateEnd;
    /**
     * 申请人
     */
    private String createName;
    /**
     * 申请时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoVisitorsNew{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", carNumber='" + carNumber + '\'' +
                ", visitDateStart=" + visitDateStart +
                ", visitDateEnd=" + visitDateEnd +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getVisitDateStart() {
        return visitDateStart;
    }

    public void setVisitDateStart(Date visitDateStart) {
        this.visitDateStart = visitDateStart;
    }

    public Date getVisitDateEnd() {
        return visitDateEnd;
    }

    public void setVisitDateEnd(Date visitDateEnd) {
        this.visitDateEnd = visitDateEnd;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoVisitorsNew() {
    }

    public VoVisitorsNew(Integer id, String roomName, String name, String tel, Integer sex, String carNumber, Date visitDateStart, Date visitDateEnd, String createName, Date createDate) {
        this.id = id;
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.carNumber = carNumber;
        this.visitDateStart = visitDateStart;
        this.visitDateEnd = visitDateEnd;
        this.createName = createName;
        this.createDate = createDate;
    }
}
