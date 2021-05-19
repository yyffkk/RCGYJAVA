package com.api.model.operationManagement;

import java.util.Date;

/**
 * 钥匙借用搜索条件
 */
public class SearchKeyBorrow {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 借取编号/申请编号
     */
    private String code;
    /**
     * 借取人/申请人
     */
    private String borrowerName;
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
     * 审核时间开始
     */
    private Date auditDateStart;
    /**
     * 审核时间结束
     */
    private Date auditDateEnd;
    /**
     * 创建时间开始/申请时间开始
     */
    private Date createDateStart;
    /**
     * 创建时间结束/申请时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchKeyBorrow{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", identity='" + identity + '\'' +
                ", tel='" + tel + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", auditDateStart=" + auditDateStart +
                ", auditDateEnd=" + auditDateEnd +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
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

    public Date getAuditDateStart() {
        return auditDateStart;
    }

    public void setAuditDateStart(Date auditDateStart) {
        this.auditDateStart = auditDateStart;
    }

    public Date getAuditDateEnd() {
        return auditDateEnd;
    }

    public void setAuditDateEnd(Date auditDateEnd) {
        this.auditDateEnd = auditDateEnd;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public SearchKeyBorrow() {
    }

    public SearchKeyBorrow(int pageNum, int size, String code, String borrowerName, String identity, String tel, String facilityName, Date auditDateStart, Date auditDateEnd, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.borrowerName = borrowerName;
        this.identity = identity;
        this.tel = tel;
        this.facilityName = facilityName;
        this.auditDateStart = auditDateStart;
        this.auditDateEnd = auditDateEnd;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
