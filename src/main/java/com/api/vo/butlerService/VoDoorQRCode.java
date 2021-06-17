package com.api.vo.butlerService;

import java.util.Date;

/**
 * 门禁二维码 Vo 回显
 */
public class VoDoorQRCode {
    /**
     * 门禁二维码主键id
     */
    private Integer id;
    /**
     * 房产名称
     */
    private String roomName;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 生效时间
     */
    private Date startTime;
    /**
     * 失效时间
     */
    private Date endTime;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoDoorQRCode{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public VoDoorQRCode() {
    }

    public VoDoorQRCode(Integer id, String roomName, String name, String tel, String idCard, Date startTime, Date endTime, String createName, Date createDate) {
        this.id = id;
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.idCard = idCard;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createName = createName;
        this.createDate = createDate;
    }
}
