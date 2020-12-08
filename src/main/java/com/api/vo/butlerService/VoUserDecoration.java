package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 装修管理 Vo list回显
 */
public class VoUserDecoration {
    /**
     * 装修主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 业主
     */
    private String residentName;
    /**
     * 业主联系方式
     */
    private String residentTel;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系方式
     */
    private String tel;
    /**
     * 施工单位
     */
    private String constructionUnit;
    /**
     * 门禁卡数量
     */
    private Integer userAccessCardNum;
    /**
     * 负责人
     */
    private String constructionName;
    /**
     * 负责人联系电话
     */
    private String constructionTel;
    /**
     * 装修押金
     */
    private BigDecimal decorationDeposit;
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
    private Date actualBegin;
    /**
     * 实际结束时间
     */
    private Date actualEnd;
    /**
     * 装修垃圾清运费
     */
    private BigDecimal cleanCost;
    /**
     * 公用设施修复费
     */
    private BigDecimal serviceCost;
    /**
     * 退还押金
     */
    private BigDecimal refundDeposit;
    /**
     * 是否退还门禁卡
     */
    private Integer isReturnAccessCard;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 审批结果
     */
    private Integer approveResults;
    /**
     * 审批人
     */
    private String approveName;
    /**
     * 审批时间
     */
    private Date approveDate;
    /**
     * 最后一次完工检查情况
     */
    private Integer isQualified;
    /**
     * 备注
     */
    private String remarks2;
    /**
     * 楼栋编号
     */
    private Integer buildingNo;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 房间号
     */
    private String roomNumber;

    @Override
    public String toString() {
        return "VoUserDecoration{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", userAccessCardNum=" + userAccessCardNum +
                ", constructionName='" + constructionName + '\'' +
                ", constructionTel='" + constructionTel + '\'' +
                ", decorationDeposit=" + decorationDeposit +
                ", applicationDate=" + applicationDate +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", actualEnd=" + actualEnd +
                ", cleanCost=" + cleanCost +
                ", serviceCost=" + serviceCost +
                ", refundDeposit=" + refundDeposit +
                ", isReturnAccessCard=" + isReturnAccessCard +
                ", status=" + status +
                ", approveResults=" + approveResults +
                ", approveName='" + approveName + '\'' +
                ", approveDate=" + approveDate +
                ", isQualified=" + isQualified +
                ", remarks2='" + remarks2 + '\'' +
                ", buildingNo=" + buildingNo +
                ", unitNo=" + unitNo +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
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

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public Integer getUserAccessCardNum() {
        return userAccessCardNum;
    }

    public void setUserAccessCardNum(Integer userAccessCardNum) {
        this.userAccessCardNum = userAccessCardNum;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getConstructionTel() {
        return constructionTel;
    }

    public void setConstructionTel(String constructionTel) {
        this.constructionTel = constructionTel;
    }

    public BigDecimal getDecorationDeposit() {
        return decorationDeposit;
    }

    public void setDecorationDeposit(BigDecimal decorationDeposit) {
        this.decorationDeposit = decorationDeposit;
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

    public Date getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(Date actualBegin) {
        this.actualBegin = actualBegin;
    }

    public Date getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(Date actualEnd) {
        this.actualEnd = actualEnd;
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

    public BigDecimal getRefundDeposit() {
        return refundDeposit;
    }

    public void setRefundDeposit(BigDecimal refundDeposit) {
        this.refundDeposit = refundDeposit;
    }

    public Integer getIsReturnAccessCard() {
        return isReturnAccessCard;
    }

    public void setIsReturnAccessCard(Integer isReturnAccessCard) {
        this.isReturnAccessCard = isReturnAccessCard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApproveResults() {
        return approveResults;
    }

    public void setApproveResults(Integer approveResults) {
        this.approveResults = approveResults;
    }

    public String getApproveName() {
        return approveName;
    }

    public void setApproveName(String approveName) {
        this.approveName = approveName;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public VoUserDecoration() {
    }

    public VoUserDecoration(Integer id, String roomName, String residentName, String residentTel, String emergencyContact, String tel, String constructionUnit, Integer userAccessCardNum, String constructionName, String constructionTel, BigDecimal decorationDeposit, Date applicationDate, Date expectedBegin, Date expectedEnd, Date actualBegin, Date actualEnd, BigDecimal cleanCost, BigDecimal serviceCost, BigDecimal refundDeposit, Integer isReturnAccessCard, Integer status, Integer approveResults, String approveName, Date approveDate, Integer isQualified, String remarks2, Integer buildingNo, Integer unitNo, String roomNumber) {
        this.id = id;
        this.roomName = roomName;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
        this.constructionUnit = constructionUnit;
        this.userAccessCardNum = userAccessCardNum;
        this.constructionName = constructionName;
        this.constructionTel = constructionTel;
        this.decorationDeposit = decorationDeposit;
        this.applicationDate = applicationDate;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.actualEnd = actualEnd;
        this.cleanCost = cleanCost;
        this.serviceCost = serviceCost;
        this.refundDeposit = refundDeposit;
        this.isReturnAccessCard = isReturnAccessCard;
        this.status = status;
        this.approveResults = approveResults;
        this.approveName = approveName;
        this.approveDate = approveDate;
        this.isQualified = isQualified;
        this.remarks2 = remarks2;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomNumber = roomNumber;
    }
}
