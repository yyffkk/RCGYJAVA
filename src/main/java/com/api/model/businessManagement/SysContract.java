package com.api.model.businessManagement;

import java.util.Date;

/**
 * 合同管理model
 */
public class SysContract {
    /**
     * 合同管理主键id
     */
    private Integer id;
    /**
     * 组织部门主键Id
     */
    private Integer organizationId;
    /**
     * 入职人员主键Id
     */
    private Integer contractPerson;
    /**
     * 入职时间
     */
    private Date entryDate;
    /**
     * 上传doc文件路径
     */
    private String fileDocUrl;
    /**
     * 上传doc文件名称
     */
    private String fileDocName;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysContract{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", contractPerson=" + contractPerson +
                ", entryDate=" + entryDate +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(Integer contractPerson) {
        this.contractPerson = contractPerson;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public String getFileDocName() {
        return fileDocName;
    }

    public void setFileDocName(String fileDocName) {
        this.fileDocName = fileDocName;
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

    public SysContract() {
    }

    public SysContract(Integer id, Integer organizationId, Integer contractPerson, Date entryDate, String fileDocUrl, String fileDocName, Integer createId, Date createDate) {
        this.id = id;
        this.organizationId = organizationId;
        this.contractPerson = contractPerson;
        this.entryDate = entryDate;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.createId = createId;
        this.createDate = createDate;
    }
}
