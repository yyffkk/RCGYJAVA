package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 工程维修验收记录Vo list 回显
 */
public class ButlerRepairEngineeringAcceptanceRecordVo {
    /**
     * 维修结果主键id
     */
    private Integer id;
    /**
     * 工程维修主键id
     */
    private Integer repairEngineeringId;
    /**
     * 处理描述
     */
    private String content;
    /**
     * 材料清单
     */
    private String billMaterials;
    /**
     * 维修完成照片集合
     */
    private List<VoResourcesImg> maintenanceImgLists;
    /**
     * 维修人名称
     */
    private String createName;
    /**
     * 维修完成时间
     */
    private Date createDate;
    /**
     * 审核结果：1.通过，2.驳回
     */
    private Integer results;
    /**
     * 审核意见
     */
    private String advice;
    /**
     * 验收人
     */
    private Integer acceptancePeople;
    /**
     * 验收人名称
     */
    private String acceptancePeopleName;
    /**
     * 反馈时间
     */
    private Date acceptanceDate;
    /**
     * 验收照片集合
     */
    private List<VoResourcesImg> acceptanceImgLists;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringAcceptanceRecordVo{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", billMaterials='" + billMaterials + '\'' +
                ", maintenanceImgLists=" + maintenanceImgLists +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", results=" + results +
                ", advice='" + advice + '\'' +
                ", acceptancePeople=" + acceptancePeople +
                ", acceptancePeopleName='" + acceptancePeopleName + '\'' +
                ", acceptanceDate=" + acceptanceDate +
                ", acceptanceImgLists=" + acceptanceImgLists +
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

    public String getBillMaterials() {
        return billMaterials;
    }

    public void setBillMaterials(String billMaterials) {
        this.billMaterials = billMaterials;
    }

    public List<VoResourcesImg> getMaintenanceImgLists() {
        return maintenanceImgLists;
    }

    public void setMaintenanceImgLists(List<VoResourcesImg> maintenanceImgLists) {
        this.maintenanceImgLists = maintenanceImgLists;
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

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getAcceptancePeople() {
        return acceptancePeople;
    }

    public void setAcceptancePeople(Integer acceptancePeople) {
        this.acceptancePeople = acceptancePeople;
    }

    public String getAcceptancePeopleName() {
        return acceptancePeopleName;
    }

    public void setAcceptancePeopleName(String acceptancePeopleName) {
        this.acceptancePeopleName = acceptancePeopleName;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public List<VoResourcesImg> getAcceptanceImgLists() {
        return acceptanceImgLists;
    }

    public void setAcceptanceImgLists(List<VoResourcesImg> acceptanceImgLists) {
        this.acceptanceImgLists = acceptanceImgLists;
    }

    public ButlerRepairEngineeringAcceptanceRecordVo() {
    }

    public ButlerRepairEngineeringAcceptanceRecordVo(Integer id, Integer repairEngineeringId, String content, String billMaterials, List<VoResourcesImg> maintenanceImgLists, String createName, Date createDate, Integer results, String advice, Integer acceptancePeople, String acceptancePeopleName, Date acceptanceDate, List<VoResourcesImg> acceptanceImgLists) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.billMaterials = billMaterials;
        this.maintenanceImgLists = maintenanceImgLists;
        this.createName = createName;
        this.createDate = createDate;
        this.results = results;
        this.advice = advice;
        this.acceptancePeople = acceptancePeople;
        this.acceptancePeopleName = acceptancePeopleName;
        this.acceptanceDate = acceptanceDate;
        this.acceptanceImgLists = acceptanceImgLists;
    }
}
