package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 钥匙借取model信息
 */
public class ButlerKeyBorrow {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 借取编号
     */
    private String code;
    /**
     * 钥匙主键id
     */
    private Integer keyId;
    /**
     * 借取人主键id
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
     * 审核状态：1.待审核，2.审核通过，3.审核驳回，4.已归还
     */
    private Integer status;
    /**
     * 驳回原因
     */
    private String reason;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerKeyBorrow{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", keyId=" + keyId +
                ", borrower=" + borrower +
                ", returnDate=" + returnDate +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", status=" + status +
                ", reason='" + reason + '\'' +
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerKeyBorrow() {
    }

    public ButlerKeyBorrow(Integer id, String code, Integer keyId, Integer borrower, Date returnDate, Integer reviewer, Date auditDate, Integer status, String reason, Date createDate) {
        this.id = id;
        this.code = code;
        this.keyId = keyId;
        this.borrower = borrower;
        this.returnDate = returnDate;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.status = status;
        this.reason = reason;
        this.createDate = createDate;
    }
}
