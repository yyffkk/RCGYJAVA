package com.api.vo.app;

import java.util.Date;

/**
 * app 资讯Vo findById回显
 */
public class AppNewsVoFBI {
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
     * 资讯内容
     */
    private String content;
    /**
     * 资讯分类名称
     */
    private String newsCategoryName;
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
        return "AppNewsVoFBI{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public AppNewsVoFBI() {
    }

    public AppNewsVoFBI(Integer id, String code, String title, String content, String newsCategoryName, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.newsCategoryName = newsCategoryName;
        this.createName = createName;
        this.createDate = createDate;
    }
}
