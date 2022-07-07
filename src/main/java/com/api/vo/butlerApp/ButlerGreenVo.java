package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 绿化任务管理Vo list 回显
 */
public class ButlerGreenVo {
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
     * 负责人员名称
     */
    private String directorName;
    /**
     * 状态 1.待处理，2.已完成，3.未完成（不为数据库数据）
     */
    private Integer status;
    /**
     * 完成时间
     */
    private Date completeDate;
    /**
     * 截止时间
     */
    private Date endDate;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerGreenVo{" +
                "id=" + id +
                ", greenAreaName='" + greenAreaName + '\'' +
                ", content='" + content + '\'' +
                ", directorName='" + directorName + '\'' +
                ", status=" + status +
                ", completeDate=" + completeDate +
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

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
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

    public ButlerGreenVo() {
    }

    public ButlerGreenVo(Integer id, String greenAreaName, String content, String directorName, Integer status, Date completeDate, Date endDate, Date createDate) {
        this.id = id;
        this.greenAreaName = greenAreaName;
        this.content = content;
        this.directorName = directorName;
        this.status = status;
        this.completeDate = completeDate;
        this.endDate = endDate;
        this.createDate = createDate;
    }
}
