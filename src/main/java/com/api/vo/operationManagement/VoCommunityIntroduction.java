package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 社区介绍Vo list 回显
 */
public class VoCommunityIntroduction {
    /**
     * 社区介绍主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 启用状态 ，1.启用中，2.未启用
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
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoCommunityIntroduction{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public VoCommunityIntroduction() {
    }

    public VoCommunityIntroduction(Integer id, String name, String content, Integer status, String createName, Date nearModifyDate, Date createDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.createName = createName;
        this.nearModifyDate = nearModifyDate;
        this.createDate = createDate;
    }
}
