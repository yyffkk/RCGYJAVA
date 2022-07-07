package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 报事报修工程维修 Vo  回显
 */
public class ButlerRepairEngineeringReportVo {
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
     * 工作汇报照片
     */
    private List<VoResourcesImg> workReportImgLists;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringReportVo{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", workReportImgLists=" + workReportImgLists +
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

    public List<VoResourcesImg> getWorkReportImgLists() {
        return workReportImgLists;
    }

    public void setWorkReportImgLists(List<VoResourcesImg> workReportImgLists) {
        this.workReportImgLists = workReportImgLists;
    }

    public ButlerRepairEngineeringReportVo() {
    }

    public ButlerRepairEngineeringReportVo(Integer id, Integer repairEngineeringId, String content, Integer createId, String createName, Date createDate, List<VoResourcesImg> workReportImgLists) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.createId = createId;
        this.createName = createName;
        this.createDate = createDate;
        this.workReportImgLists = workReportImgLists;
    }
}
