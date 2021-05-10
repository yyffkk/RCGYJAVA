package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 资讯信息 Vo list 回显
 */
public class VoNewsManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 资讯编号
     */
    private String code;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯类型名称
     */
    private String newsCategoryName;
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
        return "VoNewsManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", newsCategoryName='" + newsCategoryName + '\'' +
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

    public String getNewsCategoryName() {
        return newsCategoryName;
    }

    public void setNewsCategoryName(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
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

    public VoNewsManagement() {
    }

    public VoNewsManagement(Integer id, String code, String title, String newsCategoryName, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.newsCategoryName = newsCategoryName;
        this.createName = createName;
        this.createDate = createDate;
    }
}
