package com.api.vo.butlerService;

import java.util.Date;

/**
 * 报事报修工程维修 vo list 回显
 */
public class VoRepairEngineering {
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 工程报修单号
     */
    private String code;
    /**
     * 报修区域
     */
    private String repairArea;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 状态（1.待派单（维修公司），2.待派单（维修人员），3.待接单，4.处理中（或开始整改），5.已处理（待验收），6.验收失败，7.验收成功，8.已作废，9.已取消）
     */
    private Integer status;
    /**
     * 维修员工主键id
     */
    private Integer maintenanceStaff;
    /**
     * 维修员工名称
     */
    private String maintenanceStaffName;
    /**
     * 维修单位主键id
     */
    private Integer organizationId;
    /**
     * 维修单位名称
     */
    private String organizationName;
    /**
     * 申请人主键id
     */
    private Integer createId;
    /**
     * 申请人名称
     */
    private String createName;
    /**
     * 申请人电话
     */
    private String createTel;
    /**
     * 报修时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoRepairEngineering{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", repairArea='" + repairArea + '\'' +
                ", reportDetail='" + reportDetail + '\'' +
                ", status=" + status +
                ", maintenanceStaff=" + maintenanceStaff +
                ", maintenanceStaffName='" + maintenanceStaffName + '\'' +
                ", organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createTel='" + createTel + '\'' +
                ", createDate=" + createDate +
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

    public String getRepairArea() {
        return repairArea;
    }

    public void setRepairArea(String repairArea) {
        this.repairArea = repairArea;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMaintenanceStaff() {
        return maintenanceStaff;
    }

    public void setMaintenanceStaff(Integer maintenanceStaff) {
        this.maintenanceStaff = maintenanceStaff;
    }

    public String getMaintenanceStaffName() {
        return maintenanceStaffName;
    }

    public void setMaintenanceStaffName(String maintenanceStaffName) {
        this.maintenanceStaffName = maintenanceStaffName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTel() {
        return createTel;
    }

    public void setCreateTel(String createTel) {
        this.createTel = createTel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoRepairEngineering() {
    }

    public VoRepairEngineering(Integer id, String code, String repairArea, String reportDetail, Integer status, Integer maintenanceStaff, String maintenanceStaffName, Integer organizationId, String organizationName, Integer createId, String createName, String createTel, Date createDate) {
        this.id = id;
        this.code = code;
        this.repairArea = repairArea;
        this.reportDetail = reportDetail;
        this.status = status;
        this.maintenanceStaff = maintenanceStaff;
        this.maintenanceStaffName = maintenanceStaffName;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.createId = createId;
        this.createName = createName;
        this.createTel = createTel;
        this.createDate = createDate;
    }
}
