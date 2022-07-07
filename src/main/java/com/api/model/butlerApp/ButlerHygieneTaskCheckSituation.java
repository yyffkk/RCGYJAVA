package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 卫生任务检查情况
 */
public class ButlerHygieneTaskCheckSituation {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 卫生任务主键id
     */
    private Integer hygieneTaskId;
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
        return "ButlerHygieneTaskCheckSituation{" +
                "id=" + id +
                ", hygieneTaskId=" + hygieneTaskId +
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

    public Integer getHygieneTaskId() {
        return hygieneTaskId;
    }

    public void setHygieneTaskId(Integer hygieneTaskId) {
        this.hygieneTaskId = hygieneTaskId;
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

    public ButlerHygieneTaskCheckSituation() {
    }

    public ButlerHygieneTaskCheckSituation(Integer id, Integer hygieneTaskId, Integer completion, String inspectionReport, Date createDate, Integer createId, String[] fileUrls) {
        this.id = id;
        this.hygieneTaskId = hygieneTaskId;
        this.completion = completion;
        this.inspectionReport = inspectionReport;
        this.createDate = createDate;
        this.createId = createId;
        this.fileUrls = fileUrls;
    }
}
