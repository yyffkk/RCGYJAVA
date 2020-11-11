package com.aku.model.basicArchives;

import java.util.Date;

/**
 * 车位信息
 */
public class CpmParkingSpace {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 车位编号
     */
    private String code;
    /**
     * 车位坐标
     */
    private String coordinate;
    /**
     * 车位状态
     */
    private Integer status;
    /**
     * 这位类型
     */
    private Integer type;
    /**
     * 业主id
     */
    private Integer residentId;
    /**
     * 使用人：如为同一人则和业主id相同
     */
    private Integer userId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "CpmParkingSpace{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", residentId=" + residentId +
                ", userId=" + userId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
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

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public CpmParkingSpace() {
    }

    public CpmParkingSpace(Integer id, String code, String coordinate, Integer status, Integer type, Integer residentId, Integer userId, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.code = code;
        this.coordinate = coordinate;
        this.status = status;
        this.type = type;
        this.residentId = residentId;
        this.userId = userId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
