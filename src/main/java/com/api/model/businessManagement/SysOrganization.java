package com.api.model.businessManagement;

import java.util.Date;

/**
 * 组织信息
 */
public class SysOrganization {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 组织编码
     */
    private String code;
    /**
     * 上级ID无上级则为0
     */
    private Integer parentId;
    /**
     * 主负责人id
     */
    private Integer leadingId;
    /**
     * 状态（1.正常，2.停用）
     */
    private Integer status;
    /**
     * 显示排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remake;
    /**
     * 分类（1.公司，2.部门，3.工作组）
     */
    private Integer categoryId;
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

    @Override
    public String toString() {
        return "SysOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", leadingId=" + leadingId +
                ", status=" + status +
                ", sort=" + sort +
                ", remake='" + remake + '\'' +
                ", categoryId=" + categoryId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLeadingId() {
        return leadingId;
    }

    public void setLeadingId(Integer leadingId) {
        this.leadingId = leadingId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public SysOrganization() {
    }

    public SysOrganization(Integer id, String name, String code, Integer parentId, Integer leadingId, Integer status, Integer sort, String remake, Integer categoryId, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.leadingId = leadingId;
        this.status = status;
        this.sort = sort;
        this.remake = remake;
        this.categoryId = categoryId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
