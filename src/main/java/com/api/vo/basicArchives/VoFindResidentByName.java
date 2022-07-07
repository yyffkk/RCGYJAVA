package com.api.vo.basicArchives;

/**
 * 根据业主姓名查询业主信息及房产信息
 */
public class VoFindResidentByName {
    /**
     * 业主主键id
     */
    private Integer value;
    /**
     * 业主名称
     */
    private String label;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 楼栋id
     */
    private Integer buildingId;
    /**
     * 单元id
     */
    private Integer unitId;
    /**
     * 房产Id
     */
    private Integer estateId;

    @Override
    public String toString() {
        return "VoFindResidentByName{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", roomName='" + roomName + '\'' +
                ", buildingId=" + buildingId +
                ", unitId=" + unitId +
                ", estateId=" + estateId +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public VoFindResidentByName() {
    }

    public VoFindResidentByName(Integer value, String label, String roomName, Integer buildingId, Integer unitId, Integer estateId) {
        this.value = value;
        this.label = label;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.estateId = estateId;
    }
}
