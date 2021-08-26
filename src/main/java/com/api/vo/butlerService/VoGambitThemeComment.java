package com.api.vo.butlerService;

import java.util.Date;

/**
 * 主题评论信息Vo list 回显
 */
public class VoGambitThemeComment {
    /**
     * 主题评论主键id
     */
    private Integer id;
    /**
     * 评论时间
     */
    private Date createDate;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论人
     */
    private String createName;

    @Override
    public String toString() {
        return "VoGambitThemeComment{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                ", createName='" + createName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public VoGambitThemeComment() {
    }

    public VoGambitThemeComment(Integer id, Date createDate, String content, String createName) {
        this.id = id;
        this.createDate = createDate;
        this.content = content;
        this.createName = createName;
    }
}
