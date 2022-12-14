package com.api.vo.operationManagement;

import java.util.Date;
import java.util.List;

/**
 * 物资盘点 Vo list 回显
 */
public class VoMaterialInventory {
    /**
     * 物资盘点主键id
     */
    private Integer id;
    /**
     * 盘点期次
     */
    private String periodTime;
    /**
     * 盘点种类数量
     */
    private Integer speciesNum;
    /**
     * 盘点时间开始
     */
    private Date inventoryDateStart;
    /**
     * 盘点时间结束
     */
    private Date inventoryDateEnd;
    /**
     * 物资盘点详情管理Vo 集合
     */
    private List<VoMaterialInventoryDetail> voMaterialInventoryDetailList;

    @Override
    public String toString() {
        return "VoMaterialInventory{" +
                "id=" + id +
                ", periodTime='" + periodTime + '\'' +
                ", speciesNum=" + speciesNum +
                ", inventoryDateStart=" + inventoryDateStart +
                ", inventoryDateEnd=" + inventoryDateEnd +
                ", voMaterialInventoryDetailList=" + voMaterialInventoryDetailList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public Integer getSpeciesNum() {
        return speciesNum;
    }

    public void setSpeciesNum(Integer speciesNum) {
        this.speciesNum = speciesNum;
    }

    public Date getInventoryDateStart() {
        return inventoryDateStart;
    }

    public void setInventoryDateStart(Date inventoryDateStart) {
        this.inventoryDateStart = inventoryDateStart;
    }

    public Date getInventoryDateEnd() {
        return inventoryDateEnd;
    }

    public void setInventoryDateEnd(Date inventoryDateEnd) {
        this.inventoryDateEnd = inventoryDateEnd;
    }

    public List<VoMaterialInventoryDetail> getVoMaterialInventoryDetailList() {
        return voMaterialInventoryDetailList;
    }

    public void setVoMaterialInventoryDetailList(List<VoMaterialInventoryDetail> voMaterialInventoryDetailList) {
        this.voMaterialInventoryDetailList = voMaterialInventoryDetailList;
    }

    public VoMaterialInventory() {
    }

    public VoMaterialInventory(Integer id, String periodTime, Integer speciesNum, Date inventoryDateStart, Date inventoryDateEnd, List<VoMaterialInventoryDetail> voMaterialInventoryDetailList) {
        this.id = id;
        this.periodTime = periodTime;
        this.speciesNum = speciesNum;
        this.inventoryDateStart = inventoryDateStart;
        this.inventoryDateEnd = inventoryDateEnd;
        this.voMaterialInventoryDetailList = voMaterialInventoryDetailList;
    }
}
