package com.api.model.butlerService;

import java.util.Date;

/**
 * 装修跟踪检查内容
 */
public class UserDecorationChecksContent {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查内容名称
     */
    private String name;
    /**
     * 备注（提示）
     */
    private String remake;
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

    @Override
    public String toString() {
        return "UserDecorationTrackChecksContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remake='" + remake + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
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

    public UserDecorationChecksContent() {
    }

    public UserDecorationChecksContent(Integer id, String name, String remake, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
