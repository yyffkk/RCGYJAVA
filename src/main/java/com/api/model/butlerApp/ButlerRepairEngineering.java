package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 报事报修工程维修model
 */
public class ButlerRepairEngineering {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工程报修小区（报修区域）
     */
    private String repairArea;
    /**
     * 工程报修单号
     */
    private String code;
    /**
     * 服务类型（1.工程维修）
     */
    private Integer type;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 状态（1.待派单（维修公司），2.待派单（维修人员），3.待接单，4.处理中，5.已处理，7.已作废，8.已取消）
     */
    private Integer status;
    /**
     * 维修公司主键id（组织主键id）
     */
    private Integer organizationId;
    /**
     * 维修员工
     */
    private Integer maintenanceStaff;
    /**
     * 维修人员接单时间
     */
    private Date maintenanceStaffPickSingleDate;
    /**
     * 维修公司派单人id
     */
    private Integer maintenanceCompanySendSingle;
    /**
     * 维修公司派单时间
     */
    private Date maintenanceCompanySendSingleDate;
    /**
     * 维修人员派单人id
     */
    private Integer maintenancePersonnelSendSingle;
    /**
     * 维修人员派单时间
     */
    private Date maintenancePersonnelSendSingleDate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源路径数组
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ButlerRepairEngineering{" +
                "id=" + id +
                ", repairArea='" + repairArea + '\'' +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", status=" + status +
                ", organizationId=" + organizationId +
                ", maintenanceStaff=" + maintenanceStaff +
                ", maintenanceStaffPickSingleDate=" + maintenanceStaffPickSingleDate +
                ", maintenanceCompanySendSingle=" + maintenanceCompanySendSingle +
                ", maintenanceCompanySendSingleDate=" + maintenanceCompanySendSingleDate +
                ", maintenancePersonnelSendSingle=" + maintenancePersonnelSendSingle +
                ", maintenancePersonnelSendSingleDate=" + maintenancePersonnelSendSingleDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairArea() {
        return repairArea;
    }

    public void setRepairArea(String repairArea) {
        this.repairArea = repairArea;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getMaintenanceStaff() {
        return maintenanceStaff;
    }

    public void setMaintenanceStaff(Integer maintenanceStaff) {
        this.maintenanceStaff = maintenanceStaff;
    }

    public Date getMaintenanceStaffPickSingleDate() {
        return maintenanceStaffPickSingleDate;
    }

    public void setMaintenanceStaffPickSingleDate(Date maintenanceStaffPickSingleDate) {
        this.maintenanceStaffPickSingleDate = maintenanceStaffPickSingleDate;
    }

    public Integer getMaintenanceCompanySendSingle() {
        return maintenanceCompanySendSingle;
    }

    public void setMaintenanceCompanySendSingle(Integer maintenanceCompanySendSingle) {
        this.maintenanceCompanySendSingle = maintenanceCompanySendSingle;
    }

    public Date getMaintenanceCompanySendSingleDate() {
        return maintenanceCompanySendSingleDate;
    }

    public void setMaintenanceCompanySendSingleDate(Date maintenanceCompanySendSingleDate) {
        this.maintenanceCompanySendSingleDate = maintenanceCompanySendSingleDate;
    }

    public Integer getMaintenancePersonnelSendSingle() {
        return maintenancePersonnelSendSingle;
    }

    public void setMaintenancePersonnelSendSingle(Integer maintenancePersonnelSendSingle) {
        this.maintenancePersonnelSendSingle = maintenancePersonnelSendSingle;
    }

    public Date getMaintenancePersonnelSendSingleDate() {
        return maintenancePersonnelSendSingleDate;
    }

    public void setMaintenancePersonnelSendSingleDate(Date maintenancePersonnelSendSingleDate) {
        this.maintenancePersonnelSendSingleDate = maintenancePersonnelSendSingleDate;
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

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ButlerRepairEngineering() {
    }

    public ButlerRepairEngineering(Integer id, String repairArea, String code, Integer type, String reportDetail, Integer status, Integer organizationId, Integer maintenanceStaff, Date maintenanceStaffPickSingleDate, Integer maintenanceCompanySendSingle, Date maintenanceCompanySendSingleDate, Integer maintenancePersonnelSendSingle, Date maintenancePersonnelSendSingleDate, Integer createId, Date createDate, String[] fileUrls) {
        this.id = id;
        this.repairArea = repairArea;
        this.code = code;
        this.type = type;
        this.reportDetail = reportDetail;
        this.status = status;
        this.organizationId = organizationId;
        this.maintenanceStaff = maintenanceStaff;
        this.maintenanceStaffPickSingleDate = maintenanceStaffPickSingleDate;
        this.maintenanceCompanySendSingle = maintenanceCompanySendSingle;
        this.maintenanceCompanySendSingleDate = maintenanceCompanySendSingleDate;
        this.maintenancePersonnelSendSingle = maintenancePersonnelSendSingle;
        this.maintenancePersonnelSendSingleDate = maintenancePersonnelSendSingleDate;
        this.createId = createId;
        this.createDate = createDate;
        this.fileUrls = fileUrls;
    }
}
