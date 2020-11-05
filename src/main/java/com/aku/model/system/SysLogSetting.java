package com.aku.model.system;

import java.util.Date;

/**
 * 系统日志设置表
 */
public class SysLogSetting {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 主键
     */
    private String primaryKey;
    /**
     * URL模板
     */
    private String urlTemplate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 删除脚本模板
     */
    private String deleteScriptTemplate;
    /**
     * 更新脚本模板
     */
    private String updateScriptTemplate;

    @Override
    public String toString() {
        return "SysLogSetting{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", primaryKey='" + primaryKey + '\'' +
                ", urlTemplate='" + urlTemplate + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", deleteScriptTemplate='" + deleteScriptTemplate + '\'' +
                ", updateScriptTemplate='" + updateScriptTemplate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
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

    public String getDeleteScriptTemplate() {
        return deleteScriptTemplate;
    }

    public void setDeleteScriptTemplate(String deleteScriptTemplate) {
        this.deleteScriptTemplate = deleteScriptTemplate;
    }

    public String getUpdateScriptTemplate() {
        return updateScriptTemplate;
    }

    public void setUpdateScriptTemplate(String updateScriptTemplate) {
        this.updateScriptTemplate = updateScriptTemplate;
    }

    public SysLogSetting() {
    }

    public SysLogSetting(Integer id, String tableName, String businessName, String primaryKey, String urlTemplate, Integer createId, Date createDate, String deleteScriptTemplate, String updateScriptTemplate) {
        this.id = id;
        this.tableName = tableName;
        this.businessName = businessName;
        this.primaryKey = primaryKey;
        this.urlTemplate = urlTemplate;
        this.createId = createId;
        this.createDate = createDate;
        this.deleteScriptTemplate = deleteScriptTemplate;
        this.updateScriptTemplate = updateScriptTemplate;
    }
}
