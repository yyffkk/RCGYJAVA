package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 商品分类表
 */
public class Category {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 父类id（顶级id为0）
     */
    private Integer parentId;
    /**
     * 父类层级全路径  格式：0::分割id::分割id::
     */
    private String idPath;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", idPath='" + idPath + '\'' +
                ", name='" + name + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Category() {
    }

    public Category(Integer id, Integer parentId, String idPath, String name, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.parentId = parentId;
        this.idPath = idPath;
        this.name = name;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
