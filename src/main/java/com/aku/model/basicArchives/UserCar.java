package com.aku.model.basicArchives;

import java.util.Date;

/**
 * 车辆信息表
 */
public class UserCar {
    private Integer id;
    private Integer buildingUnitEstateId;
    private Integer type;
    private String code;
    private Integer status;
    private String owner;
    private Integer idType;
    private String idNumber;
    private String tel;
    private Integer residentId;
    private Integer userId;
    private Integer parkingSpaceId;
    private Integer createId;
    private Date createDate;
    private Integer modifyId;
    private Date modifyDate;

    @Override
    public String toString() {
        return "UserCar{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", owner='" + owner + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", tel='" + tel + '\'' +
                ", residentId=" + residentId +
                ", userId=" + userId +
                ", parkingSpaceId=" + parkingSpaceId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public UserCar() {
    }

    public UserCar(Integer id, Integer buildingUnitEstateId, Integer type, String code, Integer status, String owner, Integer idType, String idNumber, String tel, Integer residentId, Integer userId, Integer parkingSpaceId, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.type = type;
        this.code = code;
        this.status = status;
        this.owner = owner;
        this.idType = idType;
        this.idNumber = idNumber;
        this.tel = tel;
        this.residentId = residentId;
        this.userId = userId;
        this.parkingSpaceId = parkingSpaceId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
