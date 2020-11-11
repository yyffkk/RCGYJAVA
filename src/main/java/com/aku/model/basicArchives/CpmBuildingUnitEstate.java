package com.aku.model.basicArchives;

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

    @Override
    public String toString() {
        return "CpmBuildingUnitEstate{" +
                "id=" + id +
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

    public CpmBuildingUnitEstate() {
    }

    public CpmBuildingUnitEstate(Integer id, Integer buildingUnitId, String roomNumber, Integer status, Integer type, BigDecimal constructionArea, BigDecimal indoorArea, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
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
    }
}
