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
     * 发布状态，1.已发布，2.未发布
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoFBIRegulationManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public VoFBIRegulationManagement() {
    }

    public VoFBIRegulationManagement(Integer id, String title, String content, Integer status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }
}
