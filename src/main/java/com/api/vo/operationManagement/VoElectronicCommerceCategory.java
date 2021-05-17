package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 电子商务分类管理 Vo list 回显
 */
public class VoElectronicCommerceCategory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类编号
     */
    private String code;
    /**
     * 分类名称
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
        return "VoElectronicCommerceCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public VoElectronicCommerceCategory() {
    }

    public VoElectronicCommerceCategory(Integer id, String code, String name, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.createName = createName;
        this.createDate = createDate;
    }
}
