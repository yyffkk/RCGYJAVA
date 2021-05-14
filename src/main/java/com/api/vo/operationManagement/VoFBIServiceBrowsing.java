package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 服务浏览Vo findById 回显
 */
public class VoFBIServiceBrowsing {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 服务名称
     */
    private String name;
    /**
     * 服务介绍
     */
    private String content;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 发布时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFBIServiceBrowsing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createName='" + createName + '\'' +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFBIServiceBrowsing() {
    }

    public VoFBIServiceBrowsing(Integer id, String name, String content, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createName = createName;
        this.createDate = createDate;
    }
}
