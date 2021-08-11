package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 工程维修 维修日志【工作汇报】 Vo 回显
 */
public class VoRepairEngineeringReport {
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
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 工作汇报照片集合
     */
    private List<VoResourcesImg> workReportImgList;

    @Override
    public String toString() {
        return "VoRepairEngineeringReport{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", workReportImgList=" + workReportImgList +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getWorkReportImgList() {
        return workReportImgList;
    }

    public void setWorkReportImgList(List<VoResourcesImg> workReportImgList) {
        this.workReportImgList = workReportImgList;
    }

    public VoRepairEngineeringReport() {
    }

    public VoRepairEngineeringReport(Integer id, Integer repairEngineeringId, String content, Integer createId, String createName, Date createDate, List<VoResourcesImg> workReportImgList) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.createId = createId;
        this.createName = createName;
        this.createDate = createDate;
        this.workReportImgList = workReportImgList;
    }
}
