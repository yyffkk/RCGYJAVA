package com.api.model.my;

import java.util.Date;

/**
 * 我的车位审核model
 */
public class MyParkingSpace {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 车位主键id
     */
    private Integer parkingSpaceId;
    /**
     * 住户id
     */
    private Integer residentId;
    /**
     * 审核状态（1.审核中，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;
    /**
     * 是否删除，1.非删 0.删除(app端)
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "MyParkingSpace{" +
                "id=" + id +
                ", parkingSpaceId=" + parkingSpaceId +
                ", residentId=" + residentId +
                ", status=" + status +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", isDelete=" + isDelete +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Integer parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public MyParkingSpace() {
    }

    public MyParkingSpace(Integer id, Integer parkingSpaceId, Integer residentId, Integer status, Date effectiveTimeStart, Date effectiveTimeEnd, Integer isDelete, Date createDate) {
        this.id = id;
        this.parkingSpaceId = parkingSpaceId;
        this.residentId = residentId;
        this.status = status;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.isDelete = isDelete;
        this.createDate = createDate;
    }
}
