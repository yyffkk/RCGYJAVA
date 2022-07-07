package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 绿化区域管理 Vo list 回显
 */
public class VoGreenArea {
    /***
     * 主键id
     */
    private Integer id;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoGreenArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public VoGreenArea() {
    }

    public VoGreenArea(Integer id, String name, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.createName = createName;
        this.createDate = createDate;
    }
}
