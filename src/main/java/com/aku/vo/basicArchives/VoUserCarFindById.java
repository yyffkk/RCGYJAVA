package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 车辆信息Vo findById
 */
public class VoUserCarFindById {
    /**
     * 车辆主键id
     */
    private Integer id;
    /**
     * 车辆编号
     */
    private String code;
    /**
     * 车位主键id
     */
    private Integer parkingSpaceId;
    /**
     * 车位编号
     */
    private String parkingSpaceCode;
    /**
     * 车主姓名
     */
    private String owner;
    /**
     * 车主手机号
     */
    private String tel;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 所属房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 所属楼栋id
     */
    private Integer buildingId;
    /**
     * 所属楼栋单元id
     */
    private Integer buildingUnitId;
    /**
     * 车辆状态
     */
    private Integer status;
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
        return "VoUserCarFindById{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", parkingSpaceId=" + parkingSpaceId +
                ", parkingSpaceCode='" + parkingSpaceCode + '\'' +
                ", owner='" + owner + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", buildingId=" + buildingId +
                ", buildingUnitId=" + buildingUnitId +
                ", status=" + status +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Integer parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getParkingSpaceCode() {
        return parkingSpaceCode;
    }

    public void setParkingSpaceCode(String parkingSpaceCode) {
        this.parkingSpaceCode = parkingSpaceCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getBuildingUnitId() {
        return buildingUnitId;
    }

    public void setBuildingUnitId(Integer buildingUnitId) {
        this.buildingUnitId = buildingUnitId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public VoUserCarFindById() {
    }

    public VoUserCarFindById(Integer id, String code, Integer parkingSpaceId, String parkingSpaceCode, String owner, String tel, Integer idType, String idNumber, Integer buildingUnitEstateId, Integer buildingId, Integer buildingUnitId, Integer status, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.code = code;
        this.parkingSpaceId = parkingSpaceId;
        this.parkingSpaceCode = parkingSpaceCode;
        this.owner = owner;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.buildingId = buildingId;
        this.buildingUnitId = buildingUnitId;
        this.status = status;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
