package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 一键报警Vo list 回显
 */
public class VoOneButtonAlarm {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 房产名称
     */
    private String roomName;
    /**
     * 报警时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoOneButtonAlarm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", roomName='" + roomName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoOneButtonAlarm() {
    }

    public VoOneButtonAlarm(Integer id, String name, String tel, String roomName, Date createDate) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.roomName = roomName;
        this.createDate = createDate;
    }
}
