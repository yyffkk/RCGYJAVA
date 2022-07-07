package com.api.model.operationManagement;

import java.util.Date;

/**
 * 规程管理model信息
 */
public class SysRegulationManagement {
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
     * 发布状态，1.已发布 2.未发布
     */
    private Integer status;
    /**
     * 发布时间
     */
    private Date releaseDate;
    /**
     * 上传doc文件路径
     */
    private String fileDocUrl;
    /**
     * 上传doc文件名称
     */
    private String fileDocName;
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
        return "SysRegulationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", releaseDate=" + releaseDate +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
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

    public SysRegulationManagement() {
    }

    public SysRegulationManagement(Integer id, String title, String content, Integer status, Date releaseDate, String fileDocUrl, String fileDocName, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.releaseDate = releaseDate;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
