package com.api.model.basicArchives;

import java.util.Date;

/**
 * 车位关联信息model
 */
public class ParkingSpaceAssociation {
    /**
     * 车位id
     */
    private Integer parkingSpaceId;
    /**
     * 车位编号
     */
    private String parkingSpaceCode;
    /**
     * 车位有效时间开始
     */
    private Date effectiveTimeStart;
    /**
     * 车位有效时间结束
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "ParkingSpaceAssociation{" +
                "parkingSpaceId=" + parkingSpaceId +
                ", parkingSpaceCode='" + parkingSpaceCode + '\'' +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
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

    public ParkingSpaceAssociation() {
    }

    public ParkingSpaceAssociation(Integer parkingSpaceId, String parkingSpaceCode, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.parkingSpaceId = parkingSpaceId;
        this.parkingSpaceCode = parkingSpaceCode;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
