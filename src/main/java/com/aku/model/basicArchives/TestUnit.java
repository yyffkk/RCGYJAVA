package com.aku.model.basicArchives;

public class TestUnit {
    private Integer id;
    private Integer floors;
    private Integer unitNumber;
    private Integer isElevator;
    private String buildingId;

    @Override
    public String toString() {
        return "TestUnit{" +
                "id=" + id +
                ", floors=" + floors +
                ", unitNumber=" + unitNumber +
                ", isElevator=" + isElevator +
                ", buildingId='" + buildingId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getIsElevator() {
        return isElevator;
    }

    public void setIsElevator(Integer isElevator) {
        this.isElevator = isElevator;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public TestUnit() {
    }

    public TestUnit(Integer id, Integer floors, Integer unitNumber, Integer isElevator, String buildingId) {
        this.id = id;
        this.floors = floors;
        this.unitNumber = unitNumber;
        this.isElevator = isElevator;
        this.buildingId = buildingId;
    }
}
