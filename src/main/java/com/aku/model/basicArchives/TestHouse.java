package com.aku.model.basicArchives;

public class TestHouse {
    private Integer id;
    private String name;
    private String ownerName;
    private Integer houseSpace;
    private Integer carpetSpace;
    private Integer houseStatus;
    private Integer houseType;
    private String ownerTel;
    private Integer certificateType;
    private String certificateNumber;
    private String buildingId;
    private Integer unitId;

    @Override
    public String toString() {
        return "TestHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", houseSpace=" + houseSpace +
                ", carpetSpace=" + carpetSpace +
                ", houseStatus=" + houseStatus +
                ", houseType=" + houseType +
                ", ownerTel='" + ownerTel + '\'' +
                ", certificateType=" + certificateType +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", unitId=" + unitId +
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getHouseSpace() {
        return houseSpace;
    }

    public void setHouseSpace(Integer houseSpace) {
        this.houseSpace = houseSpace;
    }

    public Integer getCarpetSpace() {
        return carpetSpace;
    }

    public void setCarpetSpace(Integer carpetSpace) {
        this.carpetSpace = carpetSpace;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public TestHouse() {
    }

    public TestHouse(Integer id, String name, String ownerName, Integer houseSpace, Integer carpetSpace, Integer houseStatus, Integer houseType, String ownerTel, Integer certificateType, String certificateNumber, String buildingId, Integer unitId) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.houseSpace = houseSpace;
        this.carpetSpace = carpetSpace;
        this.houseStatus = houseStatus;
        this.houseType = houseType;
        this.ownerTel = ownerTel;
        this.certificateType = certificateType;
        this.certificateNumber = certificateNumber;
        this.buildingId = buildingId;
        this.unitId = unitId;
    }
}
