package com.api.model.operationManagement;

import java.util.Date;

/**
 * 卫生任务model信息
 */
public class SysHygieneTask {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 卫生区域主键id
     */
    private Integer hygieneAreaId;
    /**
     * 工作内容
     */
    private String content;
    /**
     * 负责人员主键id(物业表)
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
        return "HygieneTask{" +
                "id=" + id +
                ", hygieneAreaId=" + hygieneAreaId +
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

    public Integer getHygieneAreaId() {
        return hygieneAreaId;
    }

    public void setHygieneAreaId(Integer hygieneAreaId) {
        this.hygieneAreaId = hygieneAreaId;
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

    public SysHygieneTask() {
    }

    public SysHygieneTask(Integer id, Integer hygieneAreaId, String content, Integer director, Integer status, Date complete, Date endDate, Integer createId, Date createDate) {
        this.id = id;
        this.hygieneAreaId = hygieneAreaId;
        this.content = content;
        this.director = director;
        this.status = status;
        this.complete = complete;
        this.endDate = endDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
