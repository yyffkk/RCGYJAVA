package com.aku.model.basicArchives;

/**
 * 住户房产关联表
 */
public class CpmResidentEstate {
    private Integer id;
    private Integer buildingUnitEstateId;
    private Integer residentId;

    @Override
    public String toString() {
        return "CpmResidentEstate{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", residentId=" + residentId +
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

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public CpmResidentEstate() {
    }

    public CpmResidentEstate(Integer id, Integer buildingUnitEstateId, Integer residentId) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.residentId = residentId;
    }
}
