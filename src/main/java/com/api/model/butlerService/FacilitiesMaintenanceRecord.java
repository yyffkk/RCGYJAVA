package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施设备保养记录
 */
public class FacilitiesMaintenanceRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施/设备主键id
     */
    private Integer facilitiesManageId;
    /**
     * 检测日期
     */
    private Date checkDate;
    /**
     * 设备/设施状况
     */
    private String status;
    /**
     * 管理人
     */
    private String administrator;
    /**
     * 详情
     */
    private String details;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "FacilitiesMaintenanceRecord{" +
                "id=" + id +
                ", facilitiesManageId=" + facilitiesManageId +
                ", checkDate=" + checkDate +
                ", status='" + status + '\'' +
                ", administrator='" + administrator + '\'' +
                ", details='" + details + '\'' +
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

    public Integer getFacilitiesManageId() {
        return facilitiesManageId;
    }

    public void setFacilitiesManageId(Integer facilitiesManageId) {
        this.facilitiesManageId = facilitiesManageId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public FacilitiesMaintenanceRecord() {
    }

    public FacilitiesMaintenanceRecord(Integer id, Integer facilitiesManageId, Date checkDate, String status, String administrator, String details, Integer createId, Date createDate) {
        this.id = id;
        this.facilitiesManageId = facilitiesManageId;
        this.checkDate = checkDate;
        this.status = status;
        this.administrator = administrator;
        this.details = details;
        this.createId = createId;
        this.createDate = createDate;
    }
}
