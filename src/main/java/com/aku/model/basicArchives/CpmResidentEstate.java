package com.aku.model.basicArchives;

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
    private Date effective_time_start;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effective_time_end;

    @Override
    public String toString() {
        return "CpmResidentEstate{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", residentId=" + residentId +
                ", effective_time_start=" + effective_time_start +
                ", effective_time_end=" + effective_time_end +
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

    public Date getEffective_time_start() {
        return effective_time_start;
    }

    public void setEffective_time_start(Date effective_time_start) {
        this.effective_time_start = effective_time_start;
    }

    public Date getEffective_time_end() {
        return effective_time_end;
    }

    public void setEffective_time_end(Date effective_time_end) {
        this.effective_time_end = effective_time_end;
    }

    public CpmResidentEstate() {
    }

    public CpmResidentEstate(Integer id, Integer buildingUnitEstateId, Integer residentId, Date effective_time_start, Date effective_time_end) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.residentId = residentId;
        this.effective_time_start = effective_time_start;
        this.effective_time_end = effective_time_end;
    }
}
