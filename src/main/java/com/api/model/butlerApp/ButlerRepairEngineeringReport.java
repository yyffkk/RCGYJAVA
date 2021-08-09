package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 报事报修工程维修工作汇报model
 */
public class ButlerRepairEngineeringReport {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工程维修主键id
     */
    private Integer repairEngineeringId;
    /**
     * 工作描述
     */
    private String content;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 工作汇报照片路径
     */
    private String[] workReportImgUrls;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringReport{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", workReportImgUrls=" + Arrays.toString(workReportImgUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairEngineeringId() {
        return repairEngineeringId;
    }

    public void setRepairEngineeringId(Integer repairEngineeringId) {
        this.repairEngineeringId = repairEngineeringId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String[] getWorkReportImgUrls() {
        return workReportImgUrls;
    }

    public void setWorkReportImgUrls(String[] workReportImgUrls) {
        this.workReportImgUrls = workReportImgUrls;
    }

    public ButlerRepairEngineeringReport() {
    }

    public ButlerRepairEngineeringReport(Integer id, Integer repairEngineeringId, String content, Integer createId, Date createDate, String[] workReportImgUrls) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.createId = createId;
        this.createDate = createDate;
        this.workReportImgUrls = workReportImgUrls;
    }
}
