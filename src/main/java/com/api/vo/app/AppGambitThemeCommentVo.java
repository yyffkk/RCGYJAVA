package com.api.vo.app;

import java.util.Date;

/**
 * 主题评论信息
 */
public class AppGambitThemeCommentVo {
    /**
     * 评论主键id
     */
    private Integer id;
    /**
     * 被回复人姓名（由回复id 顶级评论为0 决定）
     */
    private String parentName;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论人姓名
     */
    private String createName;
    /**
     * 评论时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppGambitThemeCommentVo{" +
                "id=" + id +
                ", parentName='" + parentName + '\'' +
                ", content='" + content + '\'' +
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public AppGambitThemeCommentVo() {
    }

    public AppGambitThemeCommentVo(Integer id, String parentName, String content, String createName, Date createDate) {
        this.id = id;
        this.parentName = parentName;
        this.content = content;
        this.createName = createName;
        this.createDate = createDate;
    }
}
