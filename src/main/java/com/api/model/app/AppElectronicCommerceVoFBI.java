package com.api.model.app;

import java.util.Date;

/**
 * app 电子商务Vo findById回显
 */
public class AppElectronicCommerceVoFBI {
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
     * 电子商务内容
     */
    private String content;
    /**
     * 电子商务分类名称
     */
    private String electronicCommerceCategoryName;
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
        return "AppElectronicCommerceVoFBI{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public AppElectronicCommerceVoFBI() {
    }

    public AppElectronicCommerceVoFBI(Integer id, String code, String title, String content, String electronicCommerceCategoryName, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.electronicCommerceCategoryName = electronicCommerceCategoryName;
        this.createName = createName;
        this.createDate = createDate;
    }
}
