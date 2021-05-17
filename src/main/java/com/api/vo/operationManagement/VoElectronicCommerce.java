package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 电子商务信息 Vo list 回显
 */
public class VoElectronicCommerce {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 电子商务编号
     */
    private String code;
    /**
     * 电子商务标题
     */
    private String title;
    /**
     * 电子商务类型名称
     */
    private String electronicCommerceCategoryName;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 发布时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoElectronicCommerce{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", electronicCommerceCategoryName='" + electronicCommerceCategoryName + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getElectronicCommerceCategoryName() {
        return electronicCommerceCategoryName;
    }

    public void setElectronicCommerceCategoryName(String electronicCommerceCategoryName) {
        this.electronicCommerceCategoryName = electronicCommerceCategoryName;
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

    public VoElectronicCommerce() {
    }

    public VoElectronicCommerce(Integer id, String code, String title, String electronicCommerceCategoryName, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.electronicCommerceCategoryName = electronicCommerceCategoryName;
        this.createName = createName;
        this.createDate = createDate;
    }
}
