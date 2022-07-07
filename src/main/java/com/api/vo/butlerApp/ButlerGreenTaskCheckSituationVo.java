package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 绿化任务检查情况 Vo list 回显
 */
public class ButlerGreenTaskCheckSituationVo {
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
     * 检查人名称
     */
    private String createName;
    /**
     * 照片上传路径数组
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "ButlerGreenTaskCheckSituationVo{" +
                "id=" + id +
                ", greenTaskId=" + greenTaskId +
                ", completion=" + completion +
                ", inspectionReport='" + inspectionReport + '\'' +
                ", createDate=" + createDate +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", imgList=" + imgList +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public ButlerGreenTaskCheckSituationVo() {
    }

    public ButlerGreenTaskCheckSituationVo(Integer id, Integer greenTaskId, Integer completion, String inspectionReport, Date createDate, Integer createId, String createName, List<VoResourcesImg> imgList) {
        this.id = id;
        this.greenTaskId = greenTaskId;
        this.completion = completion;
        this.inspectionReport = inspectionReport;
        this.createDate = createDate;
        this.createId = createId;
        this.createName = createName;
        this.imgList = imgList;
    }
}
