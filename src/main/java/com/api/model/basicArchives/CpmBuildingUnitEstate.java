package com.api.model.basicArchives;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 楼宇单元房产信息
 */
public class CpmBuildingUnitEstate {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 楼栋id
     */
    private Integer buildingId;
    /**
     * 楼宇单元id
     */
    private Integer buildingUnitId;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 房间状态
     */
    private Integer status;
    /**
     * 房屋类型
     */
    private Integer type;
    /**
     * 建筑面积
     */
    private BigDecimal constructionArea;
    /**
     * 室内面积
     */
    private BigDecimal indoorArea;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除 0删除 1未删除
     */
    private Integer isDelete;
    /**
     * 对讲机设备号
     */
    private String deviceNumber;
    /**
     * 楼栋名称
     */
    private String buildingName;
    /**
     * 单元号
     */
    private Integer buildingUnitNo;
    /**
     * 业主名称（类型为业主，不为租客，亲属）
     */
    private String userResidentName;
    /**
     * 业主联系电话
     */
    private String userResidentTel;

    @Override
    public String toString() {
        return "CpmBuildingUnitEstate{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", buildingUnitId=" + buildingUnitId +
                ", roomNumber='" + roomNumber + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", constructionArea=" + constructionArea +
                ", indoorArea=" + indoorArea +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", buildingUnitNo=" + buildingUnitNo +
                ", userResidentName='" + userResidentName + '\'' +
                ", userResidentTel='" + userResidentTel + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public BigDecimal getIndoorArea() {
        return indoorArea;
    }

    public void setIndoorArea(BigDecimal indoorArea) {
        this.indoorArea = indoorArea;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getBuildingUnitNo() {
        return buildingUnitNo;
    }

    public void setBuildingUnitNo(Integer buildingUnitNo) {
        this.buildingUnitNo = buildingUnitNo;
    }

    public String getUserResidentName() {
        return userResidentName;
    }

    public void setUserResidentName(String userResidentName) {
        this.userResidentName = userResidentName;
    }

    public String getUserResidentTel() {
        return userResidentTel;
    }

    public void setUserResidentTel(String userResidentTel) {
        this.userResidentTel = userResidentTel;
    }

    public CpmBuildingUnitEstate() {
    }

    public CpmBuildingUnitEstate(Integer id, Integer buildingId, Integer buildingUnitId, String roomNumber, Integer status, Integer type, BigDecimal constructionArea, BigDecimal indoorArea, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, String deviceNumber, String buildingName, Integer buildingUnitNo, String userResidentName, String userResidentTel) {
        this.id = id;
        this.buildingId = buildingId;
        this.buildingUnitId = buildingUnitId;
        this.roomNumber = roomNumber;
        this.status = status;
        this.type = type;
        this.constructionArea = constructionArea;
        this.indoorArea = indoorArea;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.deviceNumber = deviceNumber;
        this.buildingName = buildingName;
        this.buildingUnitNo = buildingUnitNo;
        this.userResidentName = userResidentName;
        this.userResidentTel = userResidentTel;
    }
}
