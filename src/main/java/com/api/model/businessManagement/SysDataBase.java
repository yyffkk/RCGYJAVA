package com.api.model.businessManagement;

import java.util.Date;

/**
 * 数据库model信息
 */
public class SysDataBase {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 功能大类名称
     */
    private String functionType;
    /**
     * 功能名
     */
    private String functionName;
    /**
     * 字段名称
     */
    private String fieldName;
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
        return "SysDataBase{" +
                "id=" + id +
                ", functionType='" + functionType + '\'' +
                ", functionName='" + functionName + '\'' +
                ", fieldName='" + fieldName + '\'' +
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

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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

    public SysDataBase() {
    }

    public SysDataBase(Integer id, String functionType, String functionName, String fieldName, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.functionType = functionType;
        this.functionName = functionName;
        this.fieldName = fieldName;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
