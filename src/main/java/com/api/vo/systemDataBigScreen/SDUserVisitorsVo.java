package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 访客记录Vo list 回显
 */
public class SDUserVisitorsVo {
    /**
     * 房间号
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
     * 邀请人姓名
     */
    private String inviteName;
    /**
     * 预计到访时间
     */
    private Date expectedVisitDate;
    /**
     * 实际到访时间
     */
    private Date visitDate;

    @Override
    public String toString() {
        return "SDUserVisitorsVo{" +
                "roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", inviteName='" + inviteName + '\'' +
                ", expectedVisitDate=" + expectedVisitDate +
                ", visitDate=" + visitDate +
                '}';
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

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
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

    public SDUserVisitorsVo() {
    }

    public SDUserVisitorsVo(String roomName, String name, String tel, String inviteName, Date expectedVisitDate, Date visitDate) {
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.inviteName = inviteName;
        this.expectedVisitDate = expectedVisitDate;
        this.visitDate = visitDate;
    }
}
