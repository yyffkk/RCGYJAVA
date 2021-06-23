package com.api.vo.app;

/**
 * app 租赁信息 Vo list 回显
 */
public class AppLeaseVo {
    /**
     * 租赁主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 人才类型：1.一类人才，2.二类人才，3.三类人才
     */
    private Integer type;
    /**
     * 房屋户型
     */
    private String estateType;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
     */
    private Integer status;

    @Override
    public String toString() {
        return "AppLeaseVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", estateType='" + estateType + '\'' +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AppLeaseVo() {
    }

    public AppLeaseVo(Integer id, String roomName, Integer type, String estateType, Integer status) {
        this.id = id;
        this.roomName = roomName;
        this.type = type;
        this.estateType = estateType;
        this.status = status;
    }
}
