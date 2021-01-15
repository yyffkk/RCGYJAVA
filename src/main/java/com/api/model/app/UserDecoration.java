package com.api.model.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 装修信息表 model
 */
public class UserDecoration {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修单元房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 业主id
     */
    private Integer residentId;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 状态(1.未开始，2.装修中，3.装修结束-未退押金，4.装修结束-已退押金，5.已结束，6.已作废)
     */
    private Integer status;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系人电话
     */
    private String tel;
    /**
     * 装修押金（元）【最开始填入信息】
     */
    private BigDecimal decorationDeposit;
    /**
     * 装修垃圾清理费(初始为0)
     */
    private BigDecimal cleanCost;
    /**
     * 公共设施修复费(初始为0）
     */
    private BigDecimal serviceCost;
    /**
     * 申请时间
     */
    private Date applicationDate;
    /**
     * 预计开始时间
     */
    private Date expectedBegin;
    /**
     * 预计结束时间
     */
    private Date expectedEnd;
    /**
     * 实际开始时间
     */
    private BigDecimal actualBegin;
    /**
     * 实际结束时间
     */
    private BigDecimal actualEnd;
    /**
     * 退还押金（初始为0）
     */
    private BigDecimal refundDeposit;
    /**
     * 审批结果
     */
    private Integer approveResults;
    /**
     * 审批人
     */
    private Integer approveId;
    /**
     * 审批时间
     */
    private Date approveDate;
    /**
     * 备注
     */
    private String remakes2;
    /**
     * 最后一次检查是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;
    /**
     * 是否退还门禁卡，0未退还，1退还 （初始为0.未退还）
     */
    private Integer isReturnAccessCard;

    @Override
    public String toString() {
        return "UserDecoration{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", residentId=" + residentId +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", status=" + status +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
                ", decorationDeposit=" + decorationDeposit +
                ", cleanCost=" + cleanCost +
                ", serviceCost=" + serviceCost +
                ", applicationDate=" + applicationDate +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", actualEnd=" + actualEnd +
                ", refundDeposit=" + refundDeposit +
                ", approveResults=" + approveResults +
                ", approveId=" + approveId +
                ", approveDate=" + approveDate +
                ", remakes2='" + remakes2 + '\'' +
                ", isQualified=" + isQualified +
                ", isReturnAccessCard=" + isReturnAccessCard +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getDecorationDeposit() {
        return decorationDeposit;
    }

    public void setDecorationDeposit(BigDecimal decorationDeposit) {
        this.decorationDeposit = decorationDeposit;
    }

    public BigDecimal getCleanCost() {
        return cleanCost;
    }

    public void setCleanCost(BigDecimal cleanCost) {
        this.cleanCost = cleanCost;
    }

    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getExpectedBegin() {
        return expectedBegin;
    }

    public void setExpectedBegin(Date expectedBegin) {
        this.expectedBegin = expectedBegin;
    }

    public Date getExpectedEnd() {
        return expectedEnd;
    }

    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    public BigDecimal getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(BigDecimal actualBegin) {
        this.actualBegin = actualBegin;
    }

    public BigDecimal getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(BigDecimal actualEnd) {
        this.actualEnd = actualEnd;
    }

    public BigDecimal getRefundDeposit() {
        return refundDeposit;
    }

    public void setRefundDeposit(BigDecimal refundDeposit) {
        this.refundDeposit = refundDeposit;
    }

    public Integer getApproveResults() {
        return approveResults;
    }

    public void setApproveResults(Integer approveResults) {
        this.approveResults = approveResults;
    }

    public Integer getApproveId() {
        return approveId;
    }

    public void setApproveId(Integer approveId) {
        this.approveId = approveId;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getRemakes2() {
        return remakes2;
    }

    public void setRemakes2(String remakes2) {
        this.remakes2 = remakes2;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public Integer getIsReturnAccessCard() {
        return isReturnAccessCard;
    }

    public void setIsReturnAccessCard(Integer isReturnAccessCard) {
        this.isReturnAccessCard = isReturnAccessCard;
    }

    public UserDecoration() {
    }

    public UserDecoration(Integer id, Integer buildingUnitEstateId, Integer residentId, String constructionUnit, Integer status, String emergencyContact, String tel, BigDecimal decorationDeposit, BigDecimal cleanCost, BigDecimal serviceCost, Date applicationDate, Date expectedBegin, Date expectedEnd, BigDecimal actualBegin, BigDecimal actualEnd, BigDecimal refundDeposit, Integer approveResults, Integer approveId, Date approveDate, String remakes2, Integer isQualified, Integer isReturnAccessCard) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.residentId = residentId;
        this.constructionUnit = constructionUnit;
        this.status = status;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
        this.decorationDeposit = decorationDeposit;
        this.cleanCost = cleanCost;
        this.serviceCost = serviceCost;
        this.applicationDate = applicationDate;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.actualEnd = actualEnd;
        this.refundDeposit = refundDeposit;
        this.approveResults = approveResults;
        this.approveId = approveId;
        this.approveDate = approveDate;
        this.remakes2 = remakes2;
        this.isQualified = isQualified;
        this.isReturnAccessCard = isReturnAccessCard;
    }
}
