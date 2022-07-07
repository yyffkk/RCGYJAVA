package com.api.model.butlerService;

import java.util.Date;

/**
 * 违禁关键字model
 */
public class SysProhibitedKeywords {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 违禁关键字
     */
    private String keywords;
    /**
     * 替换后显示的字符
     */
    private String replaces;
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
        return "SysProhibitedKeywords{" +
                "id=" + id +
                ", keywords='" + keywords + '\'' +
                ", replaces='" + replaces + '\'' +
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getReplaces() {
        return replaces;
    }

    public void setReplaces(String replaces) {
        this.replaces = replaces;
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

    public SysProhibitedKeywords() {
    }

    public SysProhibitedKeywords(Integer id, String keywords, String replaces, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.keywords = keywords;
        this.replaces = replaces;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
