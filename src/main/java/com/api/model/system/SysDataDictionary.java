package com.api.model.system;

import java.util.Date;

/**
 * 系统数据字典表
 */
public class SysDataDictionary {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 上级id
     */
    private Integer parentId;
    /**
     * 层级全路径::分割id
     */
    private String idPath;
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 值
     */
    private Integer showValue;
    /**
     * 排排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否删除 0删除 1非删
     */
    private Integer isDelete;
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
        return "SysDataDictionary{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", parentId=" + parentId +
                ", idPath='" + idPath + '\'' +
                ", showName='" + showName + '\'' +
                ", showValue=" + showValue +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                ", isDelete=" + isDelete +
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getShowValue() {
        return showValue;
    }

    public void setShowValue(Integer showValue) {
        this.showValue = showValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public SysDataDictionary() {
    }

    public SysDataDictionary(Integer id, String typeName, Integer parentId, String idPath, String showName, Integer showValue, Integer sort, String remarks, Integer isDelete, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.typeName = typeName;
        this.parentId = parentId;
        this.idPath = idPath;
        this.showName = showName;
        this.showValue = showValue;
        this.sort = sort;
        this.remarks = remarks;
        this.isDelete = isDelete;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
