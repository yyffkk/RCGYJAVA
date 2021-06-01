package com.api.model.basicArchives;

import java.util.Date;

/**
 * 房屋关联信息model
 */
public class HousingAssociation {
    /**
     * 楼栋id
     */
    private Integer buildingId;
    /**
     * 楼栋号
     */
    private Integer buildingNo;
    /**
     * 单元id
     */
    private Integer unitId;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 房产有效开始时间
     */
    private Date effectiveTimeStart;
    /**
     * 房产有效结束时间
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "HousingAssociation{" +
                "buildingId=" + buildingId +
                ", buildingNo=" + buildingNo +
                ", unitId=" + unitId +
                ", unitNo=" + unitNo +
                ", estateId=" + estateId +
                ", roomNumber='" + roomNumber + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public HousingAssociation() {
    }

    public HousingAssociation(Integer buildingId, Integer buildingNo, Integer unitId, Integer unitNo, Integer estateId, String roomNumber, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.buildingId = buildingId;
        this.buildingNo = buildingNo;
        this.unitId = unitId;
        this.unitNo = unitNo;
        this.estateId = estateId;
        this.roomNumber = roomNumber;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
