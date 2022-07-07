package com.api.vo.operationManagement;

/**
 * 规程管理Vo findById 回显
 */
public class VoFBIRegulationManagement {
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
     * 发布状态，1.已发布，2.未发布
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoFBIRegulationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public VoFBIRegulationManagement() {
    }

    public VoFBIRegulationManagement(Integer id, String title, String content, String fileDocUrl, String fileDocName, Integer status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.status = status;
    }
}
