package com.api.model.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * 租赁管理model
 */
public class SysLease {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父类租赁主键id，正整数代表是续签租赁（数字代表上一份租赁的主键id），0代表是第一次租赁
     */
    private Integer leaseParentId;
    /**
     * 合同编号
     */
    private String code;
    /**
     * 租户名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 可租房产id
     */
    private Integer estateId;
    /**
     * 人才类型：1.一类人才，2.二类人才，3.三类人才
     */
    private Integer type;
    /**
     * 房屋户型
     */
    private String estateType;
    /**
     * 房屋结构
     */
    private String estateStructure;
    /**
     * 建筑面积
     */
    private BigDecimal constructionArea;
    /**
     * 使用面积（室内面积）
     */
    private BigDecimal indoorArea;
    /**
     * 租金标准 x/月
     */
    private BigDecimal rentStandard;
    /**
     * 保证金
     */
    private BigDecimal margin;
    /**
     * 保证金缴纳时间
     */
    private Date marginPayDate;
    /**
     * 租赁开始时间
     */
    private Date leaseDateStart;
    /**
     * 租赁结束时间
     */
    private Date leaseDateEnd;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成,11.申请终止合同，12.申请终止失败，13.申请终止成功，14.已支付剩余租金，15申请退还保证金，16.申请退还保证金驳回，17.申请退还保证金成功（已退还）
     */
    private Integer status;
    /**
     * 审核人id
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 审核备注
     */
    private String auditRemake;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系人电话
     */
    private String emergencyContactNumber;
    /**
     * 通讯地址
     */
    private String correspondenceAddress;
    /**
     * 工作单位
     */
    private String workUnits;
    /**
     * 代缴银行
     */
    private String payBank;
    /**
     * 代缴银行账户名
     */
    private String bankAccountName;
    /**
     * 代缴银行账户
     */
    private String bankAccount;
    /**
     * 身份证照正面照片路径
     */
    private String[] idCardFrontImgUrl;
    /**
     * 身份证照背面照片路径
     */
    private String[] idCardBackImgUrl;
    /**
     * 腾空单路径
     */
    private String[] clearingSingleImgUrl;
    /**
     * 收房时间
     */
    private Date takeDate;
    /**
     * 不再计租时间
     */
    private Date notMeterRentDate;
    /**
     * 剩余需结清房租（元）
     */
    private BigDecimal requiredRent;
    /**
     * 保证金退还审核备注
     */
    private String depositRefundReviewRemake;

    @Override
    public String toString() {
        return "SysLease{" +
                "id=" + id +
                ", leaseParentId=" + leaseParentId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", estateId=" + estateId +
                ", type=" + type +
                ", estateType='" + estateType + '\'' +
                ", estateStructure='" + estateStructure + '\'' +
                ", constructionArea=" + constructionArea +
                ", indoorArea=" + indoorArea +
                ", rentStandard=" + rentStandard +
                ", margin=" + margin +
                ", marginPayDate=" + marginPayDate +
                ", leaseDateStart=" + leaseDateStart +
                ", leaseDateEnd=" + leaseDateEnd +
                ", status=" + status +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", auditRemake='" + auditRemake + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", correspondenceAddress='" + correspondenceAddress + '\'' +
                ", workUnits='" + workUnits + '\'' +
                ", payBank='" + payBank + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", idCardFrontImgUrl=" + Arrays.toString(idCardFrontImgUrl) +
                ", idCardBackImgUrl=" + Arrays.toString(idCardBackImgUrl) +
                ", clearingSingleImgUrl=" + Arrays.toString(clearingSingleImgUrl) +
                ", takeDate=" + takeDate +
                ", notMeterRentDate=" + notMeterRentDate +
                ", requiredRent=" + requiredRent +
                ", depositRefundReviewRemake='" + depositRefundReviewRemake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaseParentId() {
        return leaseParentId;
    }

    public void setLeaseParentId(Integer leaseParentId) {
        this.leaseParentId = leaseParentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public String getEstateStructure() {
        return estateStructure;
    }

    public void setEstateStructure(String estateStructure) {
        this.estateStructure = estateStructure;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public BigDecimal getIndoorArea() {
        return indoorArea;
    }

    public void setIndoorArea(BigDecimal indoorArea) {
        this.indoorArea = indoorArea;
    }

    public BigDecimal getRentStandard() {
        return rentStandard;
    }

    public void setRentStandard(BigDecimal rentStandard) {
        this.rentStandard = rentStandard;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public Date getMarginPayDate() {
        return marginPayDate;
    }

    public void setMarginPayDate(Date marginPayDate) {
        this.marginPayDate = marginPayDate;
    }

    public Date getLeaseDateStart() {
        return leaseDateStart;
    }

    public void setLeaseDateStart(Date leaseDateStart) {
        this.leaseDateStart = leaseDateStart;
    }

    public Date getLeaseDateEnd() {
        return leaseDateEnd;
    }

    public void setLeaseDateEnd(Date leaseDateEnd) {
        this.leaseDateEnd = leaseDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditRemake() {
        return auditRemake;
    }

    public void setAuditRemake(String auditRemake) {
        this.auditRemake = auditRemake;
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

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(String correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public String getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(String workUnits) {
        this.workUnits = workUnits;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String[] getIdCardFrontImgUrl() {
        return idCardFrontImgUrl;
    }

    public void setIdCardFrontImgUrl(String[] idCardFrontImgUrl) {
        this.idCardFrontImgUrl = idCardFrontImgUrl;
    }

    public String[] getIdCardBackImgUrl() {
        return idCardBackImgUrl;
    }

    public void setIdCardBackImgUrl(String[] idCardBackImgUrl) {
        this.idCardBackImgUrl = idCardBackImgUrl;
    }

    public String[] getClearingSingleImgUrl() {
        return clearingSingleImgUrl;
    }

    public void setClearingSingleImgUrl(String[] clearingSingleImgUrl) {
        this.clearingSingleImgUrl = clearingSingleImgUrl;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getNotMeterRentDate() {
        return notMeterRentDate;
    }

    public void setNotMeterRentDate(Date notMeterRentDate) {
        this.notMeterRentDate = notMeterRentDate;
    }

    public BigDecimal getRequiredRent() {
        return requiredRent;
    }

    public void setRequiredRent(BigDecimal requiredRent) {
        this.requiredRent = requiredRent;
    }

    public String getDepositRefundReviewRemake() {
        return depositRefundReviewRemake;
    }

    public void setDepositRefundReviewRemake(String depositRefundReviewRemake) {
        this.depositRefundReviewRemake = depositRefundReviewRemake;
    }

    public SysLease() {
    }

    public SysLease(Integer id, Integer leaseParentId, String code, String name, Integer sex, String idCard, String tel, Integer estateId, Integer type, String estateType, String estateStructure, BigDecimal constructionArea, BigDecimal indoorArea, BigDecimal rentStandard, BigDecimal margin, Date marginPayDate, Date leaseDateStart, Date leaseDateEnd, Integer status, Integer reviewer, Date auditDate, String auditRemake, Integer createId, Date createDate, String emergencyContact, String emergencyContactNumber, String correspondenceAddress, String workUnits, String payBank, String bankAccountName, String bankAccount, String[] idCardFrontImgUrl, String[] idCardBackImgUrl, String[] clearingSingleImgUrl, Date takeDate, Date notMeterRentDate, BigDecimal requiredRent, String depositRefundReviewRemake) {
        this.id = id;
        this.leaseParentId = leaseParentId;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.tel = tel;
        this.estateId = estateId;
        this.type = type;
        this.estateType = estateType;
        this.estateStructure = estateStructure;
        this.constructionArea = constructionArea;
        this.indoorArea = indoorArea;
        this.rentStandard = rentStandard;
        this.margin = margin;
        this.marginPayDate = marginPayDate;
        this.leaseDateStart = leaseDateStart;
        this.leaseDateEnd = leaseDateEnd;
        this.status = status;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.auditRemake = auditRemake;
        this.createId = createId;
        this.createDate = createDate;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.correspondenceAddress = correspondenceAddress;
        this.workUnits = workUnits;
        this.payBank = payBank;
        this.bankAccountName = bankAccountName;
        this.bankAccount = bankAccount;
        this.idCardFrontImgUrl = idCardFrontImgUrl;
        this.idCardBackImgUrl = idCardBackImgUrl;
        this.clearingSingleImgUrl = clearingSingleImgUrl;
        this.takeDate = takeDate;
        this.notMeterRentDate = notMeterRentDate;
        this.requiredRent = requiredRent;
        this.depositRefundReviewRemake = depositRefundReviewRemake;
    }
}
