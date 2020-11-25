package com.aku.model.basicArchives;

import java.util.Date;

/**
 * 装修表（内含负责人信息）
 */
public class CpmDecoration {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 装修状态 1。装修中 2。装修完成
     */
    private Integer status;
    /**
     * 装修负责人姓名
     */
    private String name;
    /**
     * 装修负责人手机号
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
     * 装修车辆车牌号
     */
    private String carCode;
    /**
     * 装修车辆id
     */
    private Integer carId;
    /**
     * 装修起始时间
     */
    private Date effectiveTimeStart;
    /**
     * 装修预计终止时间
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "CpmDecoration{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", carCode='" + carCode + '\'' +
                ", carId=" + carId +
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

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
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

    public CpmDecoration() {
    }

    public CpmDecoration(Integer id, Integer buildingUnitEstateId, Integer status, String name, String tel, Integer idType, String idNumber, String carCode, Integer carId, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.status = status;
        this.name = name;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.carCode = carCode;
        this.carId = carId;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
