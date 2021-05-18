package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 规程管理 Vo list 回显
 */
public class ButlerRegulationManagementVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 规程标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date releaseDate;

    @Override
    public String toString() {
        return "ButlerRegulationManagementVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ButlerRegulationManagementVo() {
    }

    public ButlerRegulationManagementVo(Integer id, String title, String content, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.releaseDate = releaseDate;
    }
}
