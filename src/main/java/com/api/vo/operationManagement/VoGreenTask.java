package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 绿化任务管理 Vo list 回显
 */
public class VoGreenTask {
    /**
     * 绿化任务主键id
     */
    private Integer id;
    /**
     * 绿化区域名称
     */
    private String greenAreaName;
    /**
     * 工作内容
     */
    private String content;
    /**
     * 负责人名称
     */
    private String directorName;
    /**
     * 状态 1.待处理，2.已完成
     */
    private Integer status;
    /**
     * 截止时间
     */
    private Date endDate;
    /**
     * 发布时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoGreenTask{" +
                "id=" + id +
                ", greenAreaName='" + greenAreaName + '\'' +
                ", content='" + content + '\'' +
                ", directorName='" + directorName + '\'' +
                ", status=" + status +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGreenAreaName() {
        return greenAreaName;
    }

    public void setGreenAreaName(String greenAreaName) {
        this.greenAreaName = greenAreaName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoGreenTask() {
    }

    public VoGreenTask(Integer id, String greenAreaName, String content, String directorName, Integer status, Date endDate, Date createDate) {
        this.id = id;
        this.greenAreaName = greenAreaName;
        this.content = content;
        this.directorName = directorName;
        this.status = status;
        this.endDate = endDate;
        this.createDate = createDate;
    }
}
