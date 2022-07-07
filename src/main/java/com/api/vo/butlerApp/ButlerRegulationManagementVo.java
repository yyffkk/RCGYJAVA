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
     * 上传doc文件路径
     */
    private String fileDocUrl;
    /**
     * 上传doc文件名称
     */
    private String fileDocName;
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
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
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

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public String getFileDocName() {
        return fileDocName;
    }

    public void setFileDocName(String fileDocName) {
        this.fileDocName = fileDocName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ButlerRegulationManagementVo() {
    }

    public ButlerRegulationManagementVo(Integer id, String title, String content, String fileDocUrl, String fileDocName, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.releaseDate = releaseDate;
    }
}
