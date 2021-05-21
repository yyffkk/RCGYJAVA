package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 钥匙借取审核Vo list 回显
 */
public class VoKeyBorrow {
    /**
     * 审核主键id
     */
    private Integer id;
    /**
     * 钥匙主键id
     */
    private Integer keyId;
    /**
     * 借取编号/申请编号
     */
    private String code;
    /**
     * 借取人/申请人
     */
    private String reviewerName;
    /**
     * 身份
     */
    private String identity;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 对应设备
     */
    private String facilityName;
    /**
     * 钥匙可借数量
     */
    private Integer loanableNum;
    /**
     * 审核状态：1.待审核，2.审核通过，3.审核驳回，4.已归还
     */
    private Integer status;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 创建时间/申请时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoKeyBorrow{" +
                "id=" + id +
                ", keyId=" + keyId +
                ", code='" + code + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", identity='" + identity + '\'' +
                ", tel='" + tel + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", loanableNum=" + loanableNum +
                ", status=" + status +
                ", auditDate=" + auditDate +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getLoanableNum() {
        return loanableNum;
    }

    public void setLoanableNum(Integer loanableNum) {
        this.loanableNum = loanableNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoKeyBorrow() {
    }

    public VoKeyBorrow(Integer id, Integer keyId, String code, String reviewerName, String identity, String tel, String facilityName, Integer loanableNum, Integer status, Date auditDate, Date createDate) {
        this.id = id;
        this.keyId = keyId;
        this.code = code;
        this.reviewerName = reviewerName;
        this.identity = identity;
        this.tel = tel;
        this.facilityName = facilityName;
        this.loanableNum = loanableNum;
        this.status = status;
        this.auditDate = auditDate;
        this.createDate = createDate;
    }
}