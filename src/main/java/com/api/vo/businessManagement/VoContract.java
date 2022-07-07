package com.api.vo.businessManagement;

import java.util.Date;

public class VoContract {
    /**
     * 合同管理主键id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 入职时间
     */
    private Date entryDate;
    /**
     * doc，docx文件路径
     */
    private String fileDocUrl;
    /**
     * doc,docx文件名称
     */
    private String fileDocName;

    @Override
    public String toString() {
        return "VoContract{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", entryDate=" + entryDate +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public VoContract() {
    }

    public VoContract(Integer id, String organizationName, String name, Integer sex, String tel, Date entryDate, String fileDocUrl, String fileDocName) {
        this.id = id;
        this.organizationName = organizationName;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.entryDate = entryDate;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
    }
}
