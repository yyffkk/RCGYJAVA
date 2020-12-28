package com.api.model.operationManagement;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 公告管理 model
 */
public class SysAnnouncementManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 推送对象
     */
    private Integer pushObject;
    /**
     * 上传照片文件
     */
    private MultipartFile excelFile;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 上传doc文件
     */
    private MultipartFile docFile;
    /**
     * doc,docx文件上传路径
     */
    private String fileDocUrl;
    /**
     * 状态（1.未发布，2.已发布）
     */
    private Integer status;
    /**
     * 定时发布时间
     */
    private Date scheduledReleaseTime;
    /**
     * 阅读量
     */
    private Integer readingVolume;
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
    /**
     * 发布时间
     */
    private Date releaseDate;

    @Override
    public String toString() {
        return "SysAnnouncementManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pushObject=" + pushObject +
                ", excelFile=" + excelFile +
                ", content='" + content + '\'' +
                ", docFile=" + docFile +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", status=" + status +
                ", scheduledReleaseTime=" + scheduledReleaseTime +
                ", readingVolume=" + readingVolume +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getPushObject() {
        return pushObject;
    }

    public void setPushObject(Integer pushObject) {
        this.pushObject = pushObject;
    }

    public MultipartFile getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(MultipartFile excelFile) {
        this.excelFile = excelFile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getDocFile() {
        return docFile;
    }

    public void setDocFile(MultipartFile docFile) {
        this.docFile = docFile;
    }

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getScheduledReleaseTime() {
        return scheduledReleaseTime;
    }

    public void setScheduledReleaseTime(Date scheduledReleaseTime) {
        this.scheduledReleaseTime = scheduledReleaseTime;
    }

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public SysAnnouncementManagement() {
    }

    public SysAnnouncementManagement(Integer id, String title, Integer pushObject, MultipartFile excelFile, String content, MultipartFile docFile, String fileDocUrl, Integer status, Date scheduledReleaseTime, Integer readingVolume, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.pushObject = pushObject;
        this.excelFile = excelFile;
        this.content = content;
        this.docFile = docFile;
        this.fileDocUrl = fileDocUrl;
        this.status = status;
        this.scheduledReleaseTime = scheduledReleaseTime;
        this.readingVolume = readingVolume;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.releaseDate = releaseDate;
    }
}
