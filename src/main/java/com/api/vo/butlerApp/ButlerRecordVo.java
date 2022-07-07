package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 申请记录Vo list 回显
 */
public class ButlerRecordVo {
    /**
     * 申请主键id
     */
    private Integer id;
    /**
     * 借取编号
     */
    private String code;
    /**
     * 审核状态：1.待审核，2.审核通过，3.审核驳回，4.已归还
     */
    private Integer status;
    /**
     * 设备名称
     */
    private String facilityName;
    /**
     * 对应设备位置
     */
    private String correspondingPosition;
    /**
     * 存放地址
     */
    private String storageLocation;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 驳回原因
     */
    private String reason;

    @Override
    public String toString() {
        return "ButlerRecordVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", facilityName='" + facilityName + '\'' +
                ", correspondingPosition='" + correspondingPosition + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", auditDate=" + auditDate +
                ", reason='" + reason + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getCorrespondingPosition() {
        return correspondingPosition;
    }

    public void setCorrespondingPosition(String correspondingPosition) {
        this.correspondingPosition = correspondingPosition;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ButlerRecordVo() {
    }

    public ButlerRecordVo(Integer id, String code, Integer status, String facilityName, String correspondingPosition, String storageLocation, Date auditDate, String reason) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.facilityName = facilityName;
        this.correspondingPosition = correspondingPosition;
        this.storageLocation = storageLocation;
        this.auditDate = auditDate;
        this.reason = reason;
    }
}
