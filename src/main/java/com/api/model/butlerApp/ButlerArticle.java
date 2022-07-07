package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 物品管理model
 */
public class ButlerArticle {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品总数量（初始为0）
     */
    private Integer quantity;
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
     * 照片资源路径数组
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ButlerArticle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", fileUrls=" + Arrays.toString(fileUrls) +
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ButlerArticle() {
    }

    public ButlerArticle(Integer id, String name, Integer quantity, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] fileUrls) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.fileUrls = fileUrls;
    }
}
