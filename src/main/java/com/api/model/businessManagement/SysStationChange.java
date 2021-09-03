package com.api.model.businessManagement;

import java.util.Date;

/**
 * 岗位变动model
 */
public class SysStationChange {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 旧岗位信息
     */
    private String oldStation;
    /**
     * 新岗位信息
     */
    private String newStation;
    /**
     * 变动原因
     */
    private String changeReason;
    /**
     * 变动时间
     */
    private Date changeDate;
    /**
     * 创建人主键id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysStationChange{" +
                "id=" + id +
                ", userId=" + userId +
                ", oldStation='" + oldStation + '\'' +
                ", newStation='" + newStation + '\'' +
                ", changeReason='" + changeReason + '\'' +
                ", changeDate=" + changeDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldStation() {
        return oldStation;
    }

    public void setOldStation(String oldStation) {
        this.oldStation = oldStation;
    }

    public String getNewStation() {
        return newStation;
    }

    public void setNewStation(String newStation) {
        this.newStation = newStation;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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

    public SysStationChange() {
    }

    public SysStationChange(Integer id, Integer userId, String oldStation, String newStation, String changeReason, Date changeDate, Integer createId, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.oldStation = oldStation;
        this.newStation = newStation;
        this.changeReason = changeReason;
        this.changeDate = changeDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
