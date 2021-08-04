package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 工程维修 Vo回显 findById
 */
public class ButlerRepairEngineeringFBIVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 报修人名称
     */
    private String createName;
    /**
     * 报修人联系电话
     */
    private String createTel;
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
     * 维修单位名称
     */
    private String organizationName;
    /**
     * 维修单位主要负责人名称
     */
    private String organizationLeadingName;
    /**
     * 维修单位主要负责人联系电话
     */
    private String organizationLeadingTel;
    /**
     * 维修员工
     */
    private Integer maintenanceStaff;
    /**
     * 维修员工部门名称
     */
    private String maintenanceStaffOrganizationName;
    /**
     * 维修员工名称
     */
    private String maintenanceStaffName;
    /**
     * 维修员工联系方式
     */
    private String maintenanceStaffTel;
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

    @Override
    public String toString() {
        return "ButlerRepairEngineeringFBIVo{" +
                "id=" + id +
                ", createName='" + createName + '\'' +
                ", createTel='" + createTel + '\'' +
                ", repairArea='" + repairArea + '\'' +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", status=" + status +
                ", organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", organizationLeadingName='" + organizationLeadingName + '\'' +
                ", organizationLeadingTel='" + organizationLeadingTel + '\'' +
                ", maintenanceStaff=" + maintenanceStaff +
                ", maintenanceStaffOrganizationName='" + maintenanceStaffOrganizationName + '\'' +
                ", maintenanceStaffName='" + maintenanceStaffName + '\'' +
                ", maintenanceStaffTel='" + maintenanceStaffTel + '\'' +
                ", maintenanceStaffPickSingleDate=" + maintenanceStaffPickSingleDate +
                ", maintenanceCompanySendSingle=" + maintenanceCompanySendSingle +
                ", maintenanceCompanySendSingleDate=" + maintenanceCompanySendSingleDate +
                ", maintenancePersonnelSendSingle=" + maintenancePersonnelSendSingle +
                ", maintenancePersonnelSendSingleDate=" + maintenancePersonnelSendSingleDate +
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationLeadingName() {
        return organizationLeadingName;
    }

    public void setOrganizationLeadingName(String organizationLeadingName) {
        this.organizationLeadingName = organizationLeadingName;
    }

    public String getOrganizationLeadingTel() {
        return organizationLeadingTel;
    }

    public void setOrganizationLeadingTel(String organizationLeadingTel) {
        this.organizationLeadingTel = organizationLeadingTel;
    }

    public Integer getMaintenanceStaff() {
        return maintenanceStaff;
    }

    public void setMaintenanceStaff(Integer maintenanceStaff) {
        this.maintenanceStaff = maintenanceStaff;
    }

    public String getMaintenanceStaffOrganizationName() {
        return maintenanceStaffOrganizationName;
    }

    public void setMaintenanceStaffOrganizationName(String maintenanceStaffOrganizationName) {
        this.maintenanceStaffOrganizationName = maintenanceStaffOrganizationName;
    }

    public String getMaintenanceStaffName() {
        return maintenanceStaffName;
    }

    public void setMaintenanceStaffName(String maintenanceStaffName) {
        this.maintenanceStaffName = maintenanceStaffName;
    }

    public String getMaintenanceStaffTel() {
        return maintenanceStaffTel;
    }

    public void setMaintenanceStaffTel(String maintenanceStaffTel) {
        this.maintenanceStaffTel = maintenanceStaffTel;
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

    public ButlerRepairEngineeringFBIVo() {
    }

    public ButlerRepairEngineeringFBIVo(Integer id, String createName, String createTel, String repairArea, String code, Integer type, String reportDetail, Integer status, Integer organizationId, String organizationName, String organizationLeadingName, String organizationLeadingTel, Integer maintenanceStaff, String maintenanceStaffOrganizationName, String maintenanceStaffName, String maintenanceStaffTel, Date maintenanceStaffPickSingleDate, Integer maintenanceCompanySendSingle, Date maintenanceCompanySendSingleDate, Integer maintenancePersonnelSendSingle, Date maintenancePersonnelSendSingleDate, Integer createId, Date createDate) {
        this.id = id;
        this.createName = createName;
        this.createTel = createTel;
        this.repairArea = repairArea;
        this.code = code;
        this.type = type;
        this.reportDetail = reportDetail;
        this.status = status;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.organizationLeadingName = organizationLeadingName;
        this.organizationLeadingTel = organizationLeadingTel;
        this.maintenanceStaff = maintenanceStaff;
        this.maintenanceStaffOrganizationName = maintenanceStaffOrganizationName;
        this.maintenanceStaffName = maintenanceStaffName;
        this.maintenanceStaffTel = maintenanceStaffTel;
        this.maintenanceStaffPickSingleDate = maintenanceStaffPickSingleDate;
        this.maintenanceCompanySendSingle = maintenanceCompanySendSingle;
        this.maintenanceCompanySendSingleDate = maintenanceCompanySendSingleDate;
        this.maintenancePersonnelSendSingle = maintenancePersonnelSendSingle;
        this.maintenancePersonnelSendSingleDate = maintenancePersonnelSendSingleDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
