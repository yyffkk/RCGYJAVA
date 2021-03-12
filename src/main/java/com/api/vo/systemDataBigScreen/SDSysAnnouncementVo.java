package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 公共资讯Vo list 回显
 */
public class SDSysAnnouncementVo {
    /**
     * 标题
     */
    private String title;
    /**
     * 状态（2.已发布）
     */
    private Integer status;
    /**
     * 发布时间
     */
    private Date releaseDate;

    @Override
    public String toString() {
        return "SDSysAnnouncementVo{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public SDSysAnnouncementVo() {
    }

    public SDSysAnnouncementVo(String title, Integer status, Date releaseDate) {
        this.title = title;
        this.status = status;
        this.releaseDate = releaseDate;
    }
}
