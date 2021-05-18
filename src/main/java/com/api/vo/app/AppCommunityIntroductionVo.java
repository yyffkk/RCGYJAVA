package com.api.vo.app;

import java.util.Date;

/**
 * app 社区介绍Vo detail 回显
 */
public class AppCommunityIntroductionVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppCommunityIntroductionVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppCommunityIntroductionVo() {
    }

    public AppCommunityIntroductionVo(Integer id, String name, String content, Date createDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createDate = createDate;
    }
}
