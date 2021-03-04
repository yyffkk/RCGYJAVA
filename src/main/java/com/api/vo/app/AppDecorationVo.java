package com.api.vo.app;

import java.util.Date;

/**
 * app装修管理Vo list 回显
 */
public class AppDecorationVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 申请时间
     */
    private Date applicationDate;

    @Override
    public String toString() {
        return "AppDecorationVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", applicationDate=" + applicationDate +
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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public AppDecorationVo() {
    }

    public AppDecorationVo(Integer id, String roomName, Integer status, Date applicationDate) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.applicationDate = applicationDate;
    }
}
