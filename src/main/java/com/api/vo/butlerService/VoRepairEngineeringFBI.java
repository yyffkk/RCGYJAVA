package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 报事报修工程维修 vo findById 回显
 */
public class VoRepairEngineeringFBI {
    /**
     * 工程维修主键id
     */
    private Integer id;
    /**
     * 状态（1.待派单（维修公司），2.待派单（维修人员），3.待接单，4.处理中（或开始整改），5.已处理（待验收），6.验收失败，7.验收成功，8.已作废，9.已取消）
     */
    private Integer status;
    /**
     * 工程维修单号
     */
    private String code;
    /**
     * 报修区域
     */
    private String repairArea;
    /**
     * 服务类型（1.工程维修）
     */
    private Integer type;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 报修人名称
     */
    private String createName;
    /**
     * 创建人联系方式
     */
    private String createTel;
    /**
     * 报修时间
     */
    private Date createDate;
    /**
     * 工程维修照片
     */
    private List<VoResourcesImg> engineeringMaintenanceImgList;
    /**
     * 维修单位主键id
     */
    private Integer organizationId;
    /**
     * 维修单位名称
     */
    private String organizationName;
    /**
     * 主负责人名称
     */
    private String leadingName;
    /**
     * 主负责人联系电话
     */
    private String leadingTel;
    /**
     * 维修员工主键id
     */
    private Integer maintenanceStaff;
    /**
     * 维修员工名称
     */
    private String maintenanceStaffName;
    /**
     * 维修员工联系电话
     */
    private String maintenanceStaffTel;
    /**
     * 维修员工所属部门名称
     */
    private String subordinateDepartmentsName;
    /**
     * 维修员工接单时间
     */
    private Date maintenanceStaffPickSingleDate;

    @Override
    public String toString() {
        return "VoRepairEngineeringFBI{" +
                "id=" + id +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", repairArea='" + repairArea + '\'' +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createTel='" + createTel + '\'' +
                ", createDate=" + createDate +
                ", engineeringMaintenanceImgList=" + engineeringMaintenanceImgList +
                ", organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", leadingName='" + leadingName + '\'' +
                ", leadingTel='" + leadingTel + '\'' +
                ", maintenanceStaff=" + maintenanceStaff +
                ", maintenanceStaffName='" + maintenanceStaffName + '\'' +
                ", maintenanceStaffTel='" + maintenanceStaffTel + '\'' +
                ", subordinateDepartmentsName='" + subordinateDepartmentsName + '\'' +
                ", maintenanceStaffPickSingleDate=" + maintenanceStaffPickSingleDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<VoResourcesImg> getEngineeringMaintenanceImgList() {
        return engineeringMaintenanceImgList;
    }

    public void setEngineeringMaintenanceImgList(List<VoResourcesImg> engineeringMaintenanceImgList) {
        this.engineeringMaintenanceImgList = engineeringMaintenanceImgList;
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

    public String getLeadingName() {
        return leadingName;
    }

    public void setLeadingName(String leadingName) {
        this.leadingName = leadingName;
    }

    public String getLeadingTel() {
        return leadingTel;
    }

    public void setLeadingTel(String leadingTel) {
        this.leadingTel = leadingTel;
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

    public String getMaintenanceStaffTel() {
        return maintenanceStaffTel;
    }

    public void setMaintenanceStaffTel(String maintenanceStaffTel) {
        this.maintenanceStaffTel = maintenanceStaffTel;
    }

    public String getSubordinateDepartmentsName() {
        return subordinateDepartmentsName;
    }

    public void setSubordinateDepartmentsName(String subordinateDepartmentsName) {
        this.subordinateDepartmentsName = subordinateDepartmentsName;
    }

    public Date getMaintenanceStaffPickSingleDate() {
        return maintenanceStaffPickSingleDate;
    }

    public void setMaintenanceStaffPickSingleDate(Date maintenanceStaffPickSingleDate) {
        this.maintenanceStaffPickSingleDate = maintenanceStaffPickSingleDate;
    }

    public VoRepairEngineeringFBI() {
    }

    public VoRepairEngineeringFBI(Integer id, Integer status, String code, String repairArea, Integer type, String reportDetail, Integer createId, String createName, String createTel, Date createDate, List<VoResourcesImg> engineeringMaintenanceImgList, Integer organizationId, String organizationName, String leadingName, String leadingTel, Integer maintenanceStaff, String maintenanceStaffName, String maintenanceStaffTel, String subordinateDepartmentsName, Date maintenanceStaffPickSingleDate) {
        this.id = id;
        this.status = status;
        this.code = code;
        this.repairArea = repairArea;
        this.type = type;
        this.reportDetail = reportDetail;
        this.createId = createId;
        this.createName = createName;
        this.createTel = createTel;
        this.createDate = createDate;
        this.engineeringMaintenanceImgList = engineeringMaintenanceImgList;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.leadingName = leadingName;
        this.leadingTel = leadingTel;
        this.maintenanceStaff = maintenanceStaff;
        this.maintenanceStaffName = maintenanceStaffName;
        this.maintenanceStaffTel = maintenanceStaffTel;
        this.subordinateDepartmentsName = subordinateDepartmentsName;
        this.maintenanceStaffPickSingleDate = maintenanceStaffPickSingleDate;
    }
}
