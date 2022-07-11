package com.api.model.operationManagement;

import java.util.Date;

/**
 * 钥匙借还/钥匙审核model管理
 */
public class KeyBorrow {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 借取/审核编号
     */
    private String code;
    /**
     * 钥匙主键id
     */
    private Integer keyId;
    /**
     * 借取人/申请人主键id
     */
    private Integer borrower;
    /**
     * 归还时间
     */
    private Date returnDate;
    /**
     * 审核人
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 审核状态：1.待审核，2.审核通过，3.审核驳回，4.归还待审核，5.归还审核驳回，6.已归还（归还审核通过）
     */
    private Integer status;
    /**
     * 驳回原因
     */
    private String reason;
    /**
     * 归还驳回原因
     */
    private String returnReason;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "KeyBorrow{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", keyId=" + keyId +
                ", borrower=" + borrower +
                ", returnDate=" + returnDate +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", createDate=" + createDate +
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

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getBorrower() {
        return borrower;
    }

    public void setBorrower(Integer borrower) {
        this.borrower = borrower;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public KeyBorrow() {
    }

    public KeyBorrow(Integer id, String code, Integer keyId, Integer borrower, Date returnDate, Integer reviewer, Date auditDate, Integer status, String reason, String returnReason, Date createDate) {
        this.id = id;
        this.code = code;
        this.keyId = keyId;
        this.borrower = borrower;
        this.returnDate = returnDate;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.status = status;
        this.reason = reason;
        this.returnReason = returnReason;
        this.createDate = createDate;
    }
}
