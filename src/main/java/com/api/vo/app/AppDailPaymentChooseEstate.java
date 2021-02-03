package com.api.vo.app;

/**
 * app 日常缴费选择房屋信息
 */
public class AppDailPaymentChooseEstate {
    /**
     * 房产id
     */
    private Integer id;
    /**
     * 房产名称
     */
    private String roomName;
    /**
     * 缴费状态 0：已缴费 >1：未缴费
     */
    private Integer status;

    @Override
    public String toString() {
        return "AppDailPaymentChooseEstate{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
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

    public AppDailPaymentChooseEstate() {
    }

    public AppDailPaymentChooseEstate(Integer id, String roomName, Integer status) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
    }
}
