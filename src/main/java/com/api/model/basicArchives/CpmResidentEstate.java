package com.api.model.basicArchives;

import java.util.Date;

/**
 * 住户房产关联表
 */
public class CpmResidentEstate {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 楼栋单元房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 住户id
     */
    private Integer residentId;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "CpmResidentEstate{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", residentId=" + residentId +
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

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
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

    public CpmResidentEstate() {
    }

    public CpmResidentEstate(Integer id, Integer buildingUnitEstateId, Integer residentId, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.residentId = residentId;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
