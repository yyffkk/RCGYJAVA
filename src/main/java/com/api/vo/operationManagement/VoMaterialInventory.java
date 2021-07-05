package com.api.vo.operationManagement;

import java.util.Date;

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

    @Override
    public String toString() {
        return "VoMaterialInventory{" +
                "id=" + id +
                ", periodTime='" + periodTime + '\'' +
                ", speciesNum=" + speciesNum +
                ", inventoryDateStart=" + inventoryDateStart +
                ", inventoryDateEnd=" + inventoryDateEnd +
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

    public VoMaterialInventory() {
    }

    public VoMaterialInventory(Integer id, String periodTime, Integer speciesNum, Date inventoryDateStart, Date inventoryDateEnd) {
        this.id = id;
        this.periodTime = periodTime;
        this.speciesNum = speciesNum;
        this.inventoryDateStart = inventoryDateStart;
        this.inventoryDateEnd = inventoryDateEnd;
    }
}
