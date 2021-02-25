package com.api.vo.basicArchives;

/**
 * 根据业主姓名查询业主信息及房产信息
 */
public class VoFindResidentByName {
    /**
     * 业主主键id
     */
    private Integer id;
    /**
     * 业主名称
     */
    private String name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomName='" + roomName + '\'' +
                ", buildingId=" + buildingId +
                ", unitId=" + unitId +
                ", estateId=" + estateId +
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

    public VoFindResidentByName(Integer id, String name, String roomName, Integer buildingId, Integer unitId, Integer estateId) {
        this.id = id;
        this.name = name;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.estateId = estateId;
    }
}
