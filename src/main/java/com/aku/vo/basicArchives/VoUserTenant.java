package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 租户显示数据返回 list集合
 */
public class VoUserTenant {
    /**
     * 租户姓名
     */
    private String name;
    /**
     * 租户手机号
     */
    private Integer tel;
    /**
     * 起始时间
     */
    private Date effectiveTimeStart;
    /**
     * 结束时间
     */
    private Date effectiveTimeEnd;
    /**
     * 租户车牌号
     */
    private String carCode;
    /**
     * 房屋id
     */
    private Integer roomId;
    /**
     * 租房屋
     */
    private String roomName;
    /**
     * 房屋状态
     */
    private Integer roomStatus;

    @Override
    public String toString() {
        return "VoUserTenantList{" +
                "name='" + name + '\'' +
                ", tel=" + tel +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", carCode='" + carCode + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomStatus=" + roomStatus +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
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

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public VoUserTenant() {
    }

    public VoUserTenant(String name, Integer tel, Date effectiveTimeStart, Date effectiveTimeEnd, String carCode, Integer roomId, String roomName, Integer roomStatus) {
        this.name = name;
        this.tel = tel;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.carCode = carCode;
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
    }
}
