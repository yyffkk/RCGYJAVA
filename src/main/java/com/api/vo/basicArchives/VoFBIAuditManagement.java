package com.api.vo.basicArchives;

import java.util.Date;

/**
 * 审核管理 Vo findById 回显
 */
public class VoFBIAuditManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 申请人姓名
     */
    private String name;
    /**
     * 申请身份（1 审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
    /**
     * 申请人手机号
     */
    private String tel;
    /**
     * 申请人证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 申请人证件号码
     */
    private String idNumber;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;
    /**
     * 业主名称
     */
    private String residentName;
    /**
     * 业主手机号
     */
    private String residentTel;
    /**
     * 提交申请时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFBIAuditManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", roomName='" + roomName + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFBIAuditManagement() {
    }

    public VoFBIAuditManagement(Integer id, String name, Integer type, String tel, Integer idType, String idNumber, String roomName, Date effectiveTimeStart, Date effectiveTimeEnd, String residentName, String residentTel, Date createDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.roomName = roomName;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.createDate = createDate;
    }
}
