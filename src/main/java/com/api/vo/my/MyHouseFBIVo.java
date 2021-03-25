package com.api.vo.my;

import java.util.Date;

/**
 * 我的房屋,再次认证回显信息 Vo findById 回显
 */
public class MyHouseFBIVo {
    /**
     * 房产审核表主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 住户类型（1审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
    /**
     * 审核状态（1.审核中，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "MyHouseFBIVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", estateId=" + estateId +
                ", type=" + type +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
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

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public MyHouseFBIVo() {
    }

    public MyHouseFBIVo(Integer id, String roomName, Integer estateId, Integer type, Integer status, String name, Integer idType, String idNumber, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.roomName = roomName;
        this.estateId = estateId;
        this.type = type;
        this.status = status;
        this.name = name;
        this.idType = idType;
        this.idNumber = idNumber;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
