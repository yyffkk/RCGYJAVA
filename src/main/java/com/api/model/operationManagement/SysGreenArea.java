package com.api.model.operationManagement;

import java.util.Date;

/**
 * 绿化区域model信息
 */
public class SysGreenArea {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;


    /**
     * 工作内容
     */
    private String content;
    /**
     * 部门
     */
    private String department;
    /**
     * 负责人员
     */
    private String charge;
    /**
     * 截止时间
     */
    private String endDate;

    @Override
    public String toString() {
        return "SysGreenArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", content=" + content +
                ", department=" + department +
                ", charge=" + charge +
                ", endDate=" + endDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getContent(){
       return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getCharge(){
        return charge;
    }

    public void setCharge(String charge){
        this.charge = charge;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public SysGreenArea() {
    }

    public SysGreenArea(Integer id, String name, Integer createId, Date createDate, Integer modifyId, Date modifyDate ,String content ,String department, String charge ,String endDate) {
        this.id = id;
        this.name = name;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;

        this.content = content;
        this.department = department;
        this.charge = charge;
        this.endDate = endDate;
    }
}
