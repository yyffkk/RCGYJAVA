package com.api.model.app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 装修信息表 model
 */
public class AppUserDecoration {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修单元房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 装修单号
     */
    private String code;
    /**
     * 申请人id
     */
    private Integer residentId;
    /**
     * 申请人类型（1.业主，3.租客）
     */
    private Integer residentType;
    /**
     * 申请时间
     */
    private Date applicationDate;
    /**
     * 装修公司【装修最开始填入信息】
     */
    private String constructionUnit;
    /**
     * 装修负责人【装修最开始填入信息】
     */
    private String director;
    /**
     * 装修负责人联系电话【装修最开始填入信息】
     */
    private String directorTel;
    /**
     * 状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 紧急联系人【装修最开始填入信息】
     */
    private String emergencyContact;
    /**
     * 紧急联系人电话【装修最开始填入信息】
     */
    private String tel;
    /**
     * 预计开始时间【装修最开始填入信息】
     */
    private Date expectedBegin;
    /**
     * 预计结束时间【装修最开始填入信息】
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
     * 退还押金（null为未退还押金）
     */
    private BigDecimal refundDeposit;
    /**
     * 租户审核结果（1.业主同意，2.业主不同意）
     */
    private Integer approveResults;
    /**
     * 租户审核人（业主端同意则为-1）
     */
    private Integer approveId;
    /**
     * 租户审核时间
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
     * 是否退还门禁卡，0未退还，1退还 （null为未发放）
     */
    private Integer isReturnAccessCard;

    @Override
    public String toString() {
        return "AppUserDecoration{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", code='" + code + '\'' +
                ", residentId=" + residentId +
                ", residentType=" + residentType +
                ", applicationDate=" + applicationDate +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", status=" + status +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getResidentType() {
        return residentType;
    }

    public void setResidentType(Integer residentType) {
        this.residentType = residentType;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
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

    public AppUserDecoration() {
    }

    public AppUserDecoration(Integer id, Integer buildingUnitEstateId, String code, Integer residentId, Integer residentType, Date applicationDate, String constructionUnit, String director, String directorTel, Integer status, String emergencyContact, String tel, Date expectedBegin, Date expectedEnd, BigDecimal actualBegin, BigDecimal actualEnd, BigDecimal refundDeposit, Integer approveResults, Integer approveId, Date approveDate, String remakes2, Integer isQualified, Integer isReturnAccessCard) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.code = code;
        this.residentId = residentId;
        this.residentType = residentType;
        this.applicationDate = applicationDate;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.status = status;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
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
