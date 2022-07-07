package com.api.vo.businessManagement;

import java.util.List;

/**
 * 组织架构Vo 回显 list
 */
public class VoOrganization {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 分类（1.公司，2.部门，3.工作组）
     */
    private Integer categoryId;
    /**
     * 主负责人
     */
    private String leadingName;
    /**
     * 电话
     */
    private String leadingTel;
    /**
     * 人数
     */
    private Integer countNum;
    /**
     * 状态（1.正常，2.停用）
     */
    private Integer status;
    /**
     * 备注
     */
    private String remake;
    /**
     * 上级ID无上级则为0
     */
    private Integer parentId;
    /**
     * 子组织集合
     */
    private List<VoOrganization> organizationList;

    @Override
    public String toString() {
        return "VoOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", leadingName='" + leadingName + '\'' +
                ", leadingTel='" + leadingTel + '\'' +
                ", countNum=" + countNum +
                ", status=" + status +
                ", remake='" + remake + '\'' +
                ", parentId=" + parentId +
                ", organizationList=" + organizationList +
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLeadingName() {
        return leadingName;
    }

    public void setLeadingName(String leadingName) {
        this.leadingName = leadingName;
    }

    public String getLeadingTel() {
        return leadingTel;
    }

    public void setLeadingTel(String leadingTel) {
        this.leadingTel = leadingTel;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<VoOrganization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<VoOrganization> organizationList) {
        this.organizationList = organizationList;
    }

    public VoOrganization() {
    }

    public VoOrganization(Integer id, String name, Integer categoryId, String leadingName, String leadingTel, Integer countNum, Integer status, String remake, Integer parentId, List<VoOrganization> organizationList) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.leadingName = leadingName;
        this.leadingTel = leadingTel;
        this.countNum = countNum;
        this.status = status;
        this.remake = remake;
        this.parentId = parentId;
        this.organizationList = organizationList;
    }
}
