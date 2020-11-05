package com.aku.model.system;

import java.util.Date;

/**
 * 操作日志表
 */
public class SysLogOptration {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 日志设置id
     */
    private Integer logSettingId;
    /**
     * 操作类型
     */
    private Integer operationType;
    /**
     * 主键值
     */
    private String primaryKeyValue;
    /**
     * 内容
     */
    private String content;
    /**
     * 连接地址
     */
    private String url;
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
        return "SysLogOptration{" +
                "id=" + id +
                ", logSettingId=" + logSettingId +
                ", operationType=" + operationType +
                ", primaryKeyValue='" + primaryKeyValue + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
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

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getPrimaryKeyValue() {
        return primaryKeyValue;
    }

    public void setPrimaryKeyValue(String primaryKeyValue) {
        this.primaryKeyValue = primaryKeyValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public SysLogOptration() {
    }

    public SysLogOptration(Integer id, Integer logSettingId, Integer operationType, String primaryKeyValue, String content, String url, Integer createId, Date createDate) {
        this.id = id;
        this.logSettingId = logSettingId;
        this.operationType = operationType;
        this.primaryKeyValue = primaryKeyValue;
        this.content = content;
        this.url = url;
        this.createId = createId;
        this.createDate = createDate;
    }
}
