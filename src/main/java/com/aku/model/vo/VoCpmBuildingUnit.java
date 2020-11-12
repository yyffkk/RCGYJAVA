package com.aku.model.vo;

import java.util.Date;

/**
 * 楼宇单元管理Vo
 */
public class VoCpmBuildingUnit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 楼宇id
     */
    private Integer buildingId;
    /**
     * 单元号
     */
    private Integer no;
    /**
     * 总层数
     */
    private Integer totalFloor;
    /**
     * 是否有电梯
     */
    private Integer isElevator;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 楼栋名称
     */
    private String buildingName;

    @Override
    public String toString() {
        return "VoCpmBuildingUnit{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", no=" + no +
                ", totalFloor=" + totalFloor +
                ", isElevator=" + isElevator +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getIsElevator() {
        return isElevator;
    }

    public void setIsElevator(Integer isElevator) {
        this.isElevator = isElevator;
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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public VoCpmBuildingUnit() {
    }

    public VoCpmBuildingUnit(Integer id, Integer buildingId, Integer no, Integer totalFloor, Integer isElevator, Integer createId, Date createDate, String buildingName) {
        this.id = id;
        this.buildingId = buildingId;
        this.no = no;
        this.totalFloor = totalFloor;
        this.isElevator = isElevator;
        this.createId = createId;
        this.createDate = createDate;
        this.buildingName = buildingName;
    }
}
