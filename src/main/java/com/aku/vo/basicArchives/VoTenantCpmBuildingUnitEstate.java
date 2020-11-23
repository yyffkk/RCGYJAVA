package com.aku.vo.basicArchives;

import java.util.Date;

/**
 * 楼宇单元房产信息(租客)
 */
public class VoTenantCpmBuildingUnitEstate {
    /**
     * 房屋主键id
     */
    private Integer id;
    /**
     * 楼栋单元id
     */
    private Integer buildingUnitId;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 租户姓名
     */
    private String name;
    /**
     * 租户手机号
     */
    private String tel;
    /**
     * 租房屋
     */
    private String roomName;
    /**
     * 有效时间开始
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "VoTenantCpmBuildingUnitEstate{" +
                "id=" + id +
                ", buildingUnitId=" + buildingUnitId +
                ", roomNumber='" + roomNumber + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", roomName='" + roomName + '\'' +
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

    public Integer getBuildingUnitId() {
        return buildingUnitId;
    }

    public void setBuildingUnitId(Integer buildingUnitId) {
        this.buildingUnitId = buildingUnitId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public VoTenantCpmBuildingUnitEstate() {
    }

    public VoTenantCpmBuildingUnitEstate(Integer id, Integer buildingUnitId, String roomNumber, String name, String tel, String roomName, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.buildingUnitId = buildingUnitId;
        this.roomNumber = roomNumber;
        this.name = name;
        this.tel = tel;
        this.roomName = roomName;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
