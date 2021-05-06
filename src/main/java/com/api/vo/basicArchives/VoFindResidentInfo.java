package com.api.vo.basicArchives;

/**
 * Vo 住户信息及房产信息
 */
public class VoFindResidentInfo {
    /**
     * 住户主键id
     */
    private Integer value;
    /**
     * 住户名称
     */
    private String label;
    /**
     * 住户手机号
     */
    private String tel;
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
        return "VoFindResidentInfo{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", tel='" + tel + '\'' +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public VoFindResidentInfo() {
    }

    public VoFindResidentInfo(Integer value, String label, String tel, String roomName, Integer buildingId, Integer unitId, Integer estateId) {
        this.value = value;
        this.label = label;
        this.tel = tel;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.estateId = estateId;
    }
}
