package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 租户显示数据返回 list集合
 */
public class VoUserTenant {
    /**
     * 租户主键id
     */
    private Integer id;
    /**
     * 租户姓名
     */
    private String name;
    /**
     * 租户手机号
     */
    private String tel;
    /**
     * 租户车牌号
     */
    private String carCode;
    /**
     * 租房屋
     */
    private String roomName;
    /**
     * 租房状态（租客房屋关联表属性字段）
     */
    private Integer roomStatus;
    /**
     * 起始时间
     */
    private Date effectiveTimeStart;
    /**
     * 结束时间
     */
    private Date effectiveTimeEnd;
    /**
     * 楼栋单元房产主键id
     */
    private Integer roomId;

    @Override
    public String toString() {
        return "VoUserTenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", carCode='" + carCode + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomStatus=" + roomStatus +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", roomId=" + roomId +
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

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public VoUserTenant() {
    }

    public VoUserTenant(Integer id, String name, String tel, String carCode, String roomName, Integer roomStatus, Date effectiveTimeStart, Date effectiveTimeEnd, Integer roomId) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.carCode = carCode;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.roomId = roomId;
    }
}
