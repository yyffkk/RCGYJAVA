package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 卫生任务Vo findById 回显
 */
public class VoFBIHygieneTask {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 卫生区域主键id
     */
    private Integer hygieneAreaId;
    /**
     * 卫生区域名称
     */
    private String hygieneAreaName;
    /**
     * 工作内容
     */
    private String content;
    /**
     * 负责人id
     */
    private Integer directorId;
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
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFBIHygieneTask{" +
                "id=" + id +
                ", hygieneAreaId=" + hygieneAreaId +
                ", hygieneAreaName='" + hygieneAreaName + '\'' +
                ", content='" + content + '\'' +
                ", directorId=" + directorId +
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

    public Integer getHygieneAreaId() {
        return hygieneAreaId;
    }

    public void setHygieneAreaId(Integer hygieneAreaId) {
        this.hygieneAreaId = hygieneAreaId;
    }

    public String getHygieneAreaName() {
        return hygieneAreaName;
    }

    public void setHygieneAreaName(String hygieneAreaName) {
        this.hygieneAreaName = hygieneAreaName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
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

    public VoFBIHygieneTask() {
    }

    public VoFBIHygieneTask(Integer id, Integer hygieneAreaId, String hygieneAreaName, String content, Integer directorId, String directorName, Integer status, Date endDate, Date createDate) {
        this.id = id;
        this.hygieneAreaId = hygieneAreaId;
        this.hygieneAreaName = hygieneAreaName;
        this.content = content;
        this.directorId = directorId;
        this.directorName = directorName;
        this.status = status;
        this.endDate = endDate;
        this.createDate = createDate;
    }
}
