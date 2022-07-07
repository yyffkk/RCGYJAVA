package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 绿化任务检查情况
 */
public class ButlerGreenTaskCheckSituation {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 绿化任务主键id
     */
    private Integer greenTaskId;
    /**
     * 完成情况，1.已完成，2.未完成
     */
    private Integer completion;
    /**
     * 检查报告
     */
    private String inspectionReport;
    /**
     * 检查时间
     */
    private Date createDate;
    /**
     * 检查人
     */
    private Integer createId;
    /**
     * 照片上传路径数组
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ButlerGreenTaskCheckSituation{" +
                "id=" + id +
                ", greenTaskId=" + greenTaskId +
                ", completion=" + completion +
                ", inspectionReport='" + inspectionReport + '\'' +
                ", createDate=" + createDate +
                ", createId=" + createId +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGreenTaskId() {
        return greenTaskId;
    }

    public void setGreenTaskId(Integer greenTaskId) {
        this.greenTaskId = greenTaskId;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public String getInspectionReport() {
        return inspectionReport;
    }

    public void setInspectionReport(String inspectionReport) {
        this.inspectionReport = inspectionReport;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ButlerGreenTaskCheckSituation() {
    }

    public ButlerGreenTaskCheckSituation(Integer id, Integer greenTaskId, Integer completion, String inspectionReport, Date createDate, Integer createId, String[] fileUrls) {
        this.id = id;
        this.greenTaskId = greenTaskId;
        this.completion = completion;
        this.inspectionReport = inspectionReport;
        this.createDate = createDate;
        this.createId = createId;
        this.fileUrls = fileUrls;
    }
}
