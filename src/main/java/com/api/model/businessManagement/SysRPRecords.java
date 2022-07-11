package com.api.model.businessManagement;

import java.util.Date;

/**
 * 奖惩记录model
 */
public class SysRPRecords {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 员工主键id
     */
    private Integer userId;
    /**
     * 发生时间
     */
    private Date happenDate;
    /**
     * 类型：1.奖励，2.惩罚
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建人主键id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysRPRecords{" +
                "id=" + id +
                ", userId=" + userId +
                ", happenDate=" + happenDate +
                ", type=" + type +
                ", content='" + content + '\'' +
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public SysRPRecords() {
    }

    public SysRPRecords(Integer id, Integer userId, Date happenDate, Integer type, String content, Integer createId, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.happenDate = happenDate;
        this.type = type;
        this.content = content;
        this.createId = createId;
        this.createDate = createDate;
    }
}
