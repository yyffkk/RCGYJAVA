package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 维修结果Vo 回显
 */
public class ButlerRepairEngineeringResultsVo {
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

    @Override
    public String toString() {
        return "ButlerRepairEngineeringResultsVo{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", content='" + content + '\'' +
                ", billMaterials='" + billMaterials + '\'' +
                ", maintenanceImgLists=" + maintenanceImgLists +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
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

    public ButlerRepairEngineeringResultsVo() {
    }

    public ButlerRepairEngineeringResultsVo(Integer id, Integer repairEngineeringId, String content, String billMaterials, List<VoResourcesImg> maintenanceImgLists, String createName, Date createDate) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.content = content;
        this.billMaterials = billMaterials;
        this.maintenanceImgLists = maintenanceImgLists;
        this.createName = createName;
        this.createDate = createDate;
    }
}
