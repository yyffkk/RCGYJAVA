package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租赁管理 model
 */
public class VoLease {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 合同编号
     */
    private String code;
    /***
     * 租户名称
     */
    private String name;
    /**
     * 性别：1.男，2.女
     */
    private Integer sex;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 可租房产名称
     */
    private String roomName;
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
     * 租赁开始时间
     */
    private Date leaseDateStart;
    /**
     * 租赁结束时间
     */
    private Date leaseDateEnd;
    /**
     * 有效（正式）合同,上传文件路径集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
     */
    private Integer status;
    /**
     * 审核人姓名
     */
    private String reviewerName;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 创建人姓名
     */
    private String createName;
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
     * 身份证照正面照片资源集合
     */
    private List<VoResourcesImg> idCardFrontFiles;
    /**
     * 身份证照背面照片路径资源集合
     */
    private List<VoResourcesImg> idCardBackFiles;
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
        return "VoLease{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", estateType='" + estateType + '\'' +
                ", estateStructure='" + estateStructure + '\'' +
                ", constructionArea=" + constructionArea +
                ", indoorArea=" + indoorArea +
                ", rentStandard=" + rentStandard +
                ", margin=" + margin +
                ", leaseDateStart=" + leaseDateStart +
                ", leaseDateEnd=" + leaseDateEnd +
                ", imgUrls=" + imgUrls +
                ", status=" + status +
                ", reviewerName='" + reviewerName + '\'' +
                ", auditDate=" + auditDate +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", correspondenceAddress='" + correspondenceAddress + '\'' +
                ", workUnits='" + workUnits + '\'' +
                ", payBank='" + payBank + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", idCardFrontFiles=" + idCardFrontFiles +
                ", idCardBackFiles=" + idCardBackFiles +
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public List<VoResourcesImg> getIdCardFrontFiles() {
        return idCardFrontFiles;
    }

    public void setIdCardFrontFiles(List<VoResourcesImg> idCardFrontFiles) {
        this.idCardFrontFiles = idCardFrontFiles;
    }

    public List<VoResourcesImg> getIdCardBackFiles() {
        return idCardBackFiles;
    }

    public void setIdCardBackFiles(List<VoResourcesImg> idCardBackFiles) {
        this.idCardBackFiles = idCardBackFiles;
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

    public VoLease() {
    }

    public VoLease(Integer id, String code, String name, Integer sex, String idCard, String tel, String roomName, Integer type, String estateType, String estateStructure, BigDecimal constructionArea, BigDecimal indoorArea, BigDecimal rentStandard, BigDecimal margin, Date leaseDateStart, Date leaseDateEnd, List<VoResourcesImg> imgUrls, Integer status, String reviewerName, Date auditDate, String createName, Date createDate, String emergencyContact, String emergencyContactNumber, String correspondenceAddress, String workUnits, String payBank, String bankAccountName, String bankAccount, List<VoResourcesImg> idCardFrontFiles, List<VoResourcesImg> idCardBackFiles, Date takeDate, Date notMeterRentDate, BigDecimal requiredRent, String depositRefundReviewRemake) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.tel = tel;
        this.roomName = roomName;
        this.type = type;
        this.estateType = estateType;
        this.estateStructure = estateStructure;
        this.constructionArea = constructionArea;
        this.indoorArea = indoorArea;
        this.rentStandard = rentStandard;
        this.margin = margin;
        this.leaseDateStart = leaseDateStart;
        this.leaseDateEnd = leaseDateEnd;
        this.imgUrls = imgUrls;
        this.status = status;
        this.reviewerName = reviewerName;
        this.auditDate = auditDate;
        this.createName = createName;
        this.createDate = createDate;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.correspondenceAddress = correspondenceAddress;
        this.workUnits = workUnits;
        this.payBank = payBank;
        this.bankAccountName = bankAccountName;
        this.bankAccount = bankAccount;
        this.idCardFrontFiles = idCardFrontFiles;
        this.idCardBackFiles = idCardBackFiles;
        this.takeDate = takeDate;
        this.notMeterRentDate = notMeterRentDate;
        this.requiredRent = requiredRent;
        this.depositRefundReviewRemake = depositRefundReviewRemake;
    }
}
