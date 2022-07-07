package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
     * 申请人姓名
     */
    private String applicationName;
    /**
     * 身份
     */
    private Integer applicationType;
    /**
     * 申请人联系方式
     */
    private String applicationTel;
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
    private String director;
    /**
     * 负责人联系电话
     */
    private String directorTel;
    /**
     * 装修押金
     */
    private BigDecimal depositPrice;
    /**
     * 装修押金附加费用集合
     */
    private List<VoDepositAdditionalCost> voDepositAdditionalCosts;
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
     * 退还押金
     */
    private BigDecimal refundDeposit;
    /**
     * 是否退还全部门禁卡
     */
    private Integer isReturnAccessCard;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 延长时间
     */
    private Integer extendTime;
    /**
     * 延长原因
     */
    private String extendReasons;
    /**
     * 最后一次完工检查是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;
    /**
     * 备注
     */
    private String remarks2;

    @Override
    public String toString() {
        return "VoUserDecoration{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", applicationType=" + applicationType +
                ", applicationTel='" + applicationTel + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", userAccessCardNum=" + userAccessCardNum +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", depositPrice=" + depositPrice +
                ", voDepositAdditionalCosts=" + voDepositAdditionalCosts +
                ", applicationDate=" + applicationDate +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", actualEnd=" + actualEnd +
                ", refundDeposit=" + refundDeposit +
                ", isReturnAccessCard=" + isReturnAccessCard +
                ", status=" + status +
                ", extendTime=" + extendTime +
                ", extendReasons='" + extendReasons + '\'' +
                ", isQualified=" + isQualified +
                ", remarks2='" + remarks2 + '\'' +
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

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationTel() {
        return applicationTel;
    }

    public void setApplicationTel(String applicationTel) {
        this.applicationTel = applicationTel;
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

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public List<VoDepositAdditionalCost> getVoDepositAdditionalCosts() {
        return voDepositAdditionalCosts;
    }

    public void setVoDepositAdditionalCosts(List<VoDepositAdditionalCost> voDepositAdditionalCosts) {
        this.voDepositAdditionalCosts = voDepositAdditionalCosts;
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

    public Integer getExtendTime() {
        return extendTime;
    }

    public void setExtendTime(Integer extendTime) {
        this.extendTime = extendTime;
    }

    public String getExtendReasons() {
        return extendReasons;
    }

    public void setExtendReasons(String extendReasons) {
        this.extendReasons = extendReasons;
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

    public VoUserDecoration() {
    }

    public VoUserDecoration(Integer id, String roomName, String applicationName, Integer applicationType, String applicationTel, String residentName, String residentTel, String emergencyContact, String tel, String constructionUnit, Integer userAccessCardNum, String director, String directorTel, BigDecimal depositPrice, List<VoDepositAdditionalCost> voDepositAdditionalCosts, Date applicationDate, Date expectedBegin, Date expectedEnd, Date actualBegin, Date actualEnd, BigDecimal refundDeposit, Integer isReturnAccessCard, Integer status, Integer extendTime, String extendReasons, Integer isQualified, String remarks2) {
        this.id = id;
        this.roomName = roomName;
        this.applicationName = applicationName;
        this.applicationType = applicationType;
        this.applicationTel = applicationTel;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
        this.constructionUnit = constructionUnit;
        this.userAccessCardNum = userAccessCardNum;
        this.director = director;
        this.directorTel = directorTel;
        this.depositPrice = depositPrice;
        this.voDepositAdditionalCosts = voDepositAdditionalCosts;
        this.applicationDate = applicationDate;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.actualEnd = actualEnd;
        this.refundDeposit = refundDeposit;
        this.isReturnAccessCard = isReturnAccessCard;
        this.status = status;
        this.extendTime = extendTime;
        this.extendReasons = extendReasons;
        this.isQualified = isQualified;
        this.remarks2 = remarks2;
    }
}
