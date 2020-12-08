package com.api.model.system;

import java.util.Date;

/**
 * 日志设置明细表
 */
public class SysSettiongDetail {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 日志设置ID
     */
    private Integer logSettingId;
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 字段显示名称
     */
    private String columnText;
    /**
     * 字段数据类型
     */
    private String columnDateType;
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
        return "SysSettiongDetail{" +
                "id=" + id +
                ", logSettingId=" + logSettingId +
                ", columnName='" + columnName + '\'' +
                ", columnText='" + columnText + '\'' +
                ", columnDateType='" + columnDateType + '\'' +
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

    public Integer getLogSettingId() {
        return logSettingId;
    }

    public void setLogSettingId(Integer logSettingId) {
        this.logSettingId = logSettingId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnText() {
        return columnText;
    }

    public void setColumnText(String columnText) {
        this.columnText = columnText;
    }

    public String getColumnDateType() {
        return columnDateType;
    }

    public void setColumnDateType(String columnDateType) {
        this.columnDateType = columnDateType;
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

    public SysSettiongDetail() {
    }

    public SysSettiongDetail(Integer id, Integer logSettingId, String columnName, String columnText, String columnDateType, Integer createId, Date createDate) {
        this.id = id;
        this.logSettingId = logSettingId;
        this.columnName = columnName;
        this.columnText = columnText;
        this.columnDateType = columnDateType;
        this.createId = createId;
        this.createDate = createDate;
    }
}
