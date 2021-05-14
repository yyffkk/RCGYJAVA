package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 规程管理 Vo list 回显
 */
public class VoRegulationManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 规程标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布状态，1.已发布，2.未发布
     */
    private Integer status;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 最近修改时间
     */
    private Date nearModifyDate;
    /**
     * 发布时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoRegulationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                ", nearModifyDate=" + nearModifyDate +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getNearModifyDate() {
        return nearModifyDate;
    }

    public void setNearModifyDate(Date nearModifyDate) {
        this.nearModifyDate = nearModifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoRegulationManagement() {
    }

    public VoRegulationManagement(Integer id, String title, String content, Integer status, String createName, Date nearModifyDate, Date createDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createName = createName;
        this.nearModifyDate = nearModifyDate;
        this.createDate = createDate;
    }
}
