package com.api.model.operationManagement;

import java.util.Arrays;
import java.util.Date;

/**
 * 电子商务管理model信息
 */
public class SysElectronicCommerce {
    /**
     * 主键Id
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
     * 电子商务分类主键Id【电子商务类型】
     */
    private Integer electronicCommerceCategoryId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 照片路径信息
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "SysElectronicCommerce{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", electronicCommerceCategoryId=" + electronicCommerceCategoryId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", imgUrls=" + Arrays.toString(imgUrls) +
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

    public Integer getElectronicCommerceCategoryId() {
        return electronicCommerceCategoryId;
    }

    public void setElectronicCommerceCategoryId(Integer electronicCommerceCategoryId) {
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public SysElectronicCommerce() {
    }

    public SysElectronicCommerce(Integer id, String code, String title, String content, Integer electronicCommerceCategoryId, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] imgUrls) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.imgUrls = imgUrls;
    }
}
