package com.api.model.basicArchives;

import java.util.Date;

/**
 * 车辆信息表
 */
public class UserCar {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 所属房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 车牌号
     */
    private String code;
    /**
     * 车辆状态
     */
    private Integer status;
    /**
     * 车主
     */
    private String owner;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 车位id
     */
    private Integer parkingSpaceId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 有效时间开始（仅限包年，包月）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（仅限包年，包月）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "UserCar{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", owner='" + owner + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", tel='" + tel + '\'' +
                ", parkingSpaceId=" + parkingSpaceId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Integer parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public UserCar() {
    }

    public UserCar(Integer id, Integer buildingUnitEstateId, String code, Integer status, String owner, Integer idType, String idNumber, String tel, Integer parkingSpaceId, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.code = code;
        this.status = status;
        this.owner = owner;
        this.idType = idType;
        this.idNumber = idNumber;
        this.tel = tel;
        this.parkingSpaceId = parkingSpaceId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
