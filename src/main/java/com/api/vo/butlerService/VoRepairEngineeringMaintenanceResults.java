package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 报事报修工程维修 Vo 完成结果及验收结果
 */
public class VoRepairEngineeringMaintenanceResults {
    /**
     * 主键id
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
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
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
     * 验收时间
     */
    private Date acceptanceDate;
    /**
     * 验收照片集合
     */
    private List<VoResourcesImg> acceptanceImgLists;

    @Override
    public String toString() {
        return "VoRepairEngineeringMaintenanceResults{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", billMaterials='" + billMaterials + '\'' +
                ", maintenanceImgLists=" + maintenanceImgLists +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", results=" + results +
                ", advice='" + advice + '\'' +
                ", acceptancePeople=" + acceptancePeople +
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

    public VoRepairEngineeringMaintenanceResults() {
    }

    public VoRepairEngineeringMaintenanceResults(Integer id, Integer repairEngineeringId, String content, String billMaterials, List<VoResourcesImg> maintenanceImgLists, Integer createId, Date createDate, Integer results, String advice, Integer acceptancePeople, Date acceptanceDate, List<VoResourcesImg> acceptanceImgLists) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.billMaterials = billMaterials;
        this.maintenanceImgLists = maintenanceImgLists;
        this.createId = createId;
        this.createDate = createDate;
        this.results = results;
        this.advice = advice;
        this.acceptancePeople = acceptancePeople;
        this.acceptanceDate = acceptanceDate;
        this.acceptanceImgLists = acceptanceImgLists;
    }
}
