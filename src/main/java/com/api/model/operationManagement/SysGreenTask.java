package com.api.model.operationManagement;

import java.util.Date;

/**
 * 绿化任务管理model信息
 */
public class SysGreenTask {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 绿化区域主键id
     */
    private Integer greenAreaId;
    /**
     * 工作内容
     */
    private String content;
    /**
     * 负责人员主键id
     */
    private Integer director;
    /**
     * 状态 1.待处理，2.已完成
     */
    private Integer status;
    /**
     * 完成时间
     */
    private Date complete;
    /**
     * 截止时间
     */
    private Date endDate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysGreenTask{" +
                "id=" + id +
                ", greenAreaId=" + greenAreaId +
                ", content='" + content + '\'' +
                ", director=" + director +
                ", status=" + status +
                ", complete=" + complete +
                ", endDate=" + endDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGreenAreaId() {
        return greenAreaId;
    }

    public void setGreenAreaId(Integer greenAreaId) {
        this.greenAreaId = greenAreaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getComplete() {
        return complete;
    }

    public void setComplete(Date complete) {
        this.complete = complete;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public SysGreenTask() {
    }

    public SysGreenTask(Integer id, Integer greenAreaId, String content, Integer director, Integer status, Date complete, Date endDate, Integer createId, Date createDate) {
        this.id = id;
        this.greenAreaId = greenAreaId;
        this.content = content;
        this.director = director;
        this.status = status;
        this.complete = complete;
        this.endDate = endDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
