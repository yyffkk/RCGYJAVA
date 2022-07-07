package com.api.model.operationManagement;

import java.util.Date;
import java.util.List;

/**
 * 物资盘点管理
 */
public class SysMaterialInventory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 盘点期次
     */
    private String periodTime;
    /**
     * 盘点时间开始
     */
    private Date inventoryDateStart;
    /**
     * 盘点时间结束
     */
    private Date inventoryDateEnd;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 物资盘点详情集合
     */
    private List<SysMaterialInventoryDetail> materialInventoryDetailList;

    @Override
    public String toString() {
        return "SysMaterialInventory{" +
                "id=" + id +
                ", periodTime='" + periodTime + '\'' +
                ", inventoryDateStart=" + inventoryDateStart +
                ", inventoryDateEnd=" + inventoryDateEnd +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", materialInventoryDetailList=" + materialInventoryDetailList +
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

    public List<SysMaterialInventoryDetail> getMaterialInventoryDetailList() {
        return materialInventoryDetailList;
    }

    public void setMaterialInventoryDetailList(List<SysMaterialInventoryDetail> materialInventoryDetailList) {
        this.materialInventoryDetailList = materialInventoryDetailList;
    }

    public SysMaterialInventory() {
    }

    public SysMaterialInventory(Integer id, String periodTime, Date inventoryDateStart, Date inventoryDateEnd, Integer createId, Date createDate, List<SysMaterialInventoryDetail> materialInventoryDetailList) {
        this.id = id;
        this.periodTime = periodTime;
        this.inventoryDateStart = inventoryDateStart;
        this.inventoryDateEnd = inventoryDateEnd;
        this.createId = createId;
        this.createDate = createDate;
        this.materialInventoryDetailList = materialInventoryDetailList;
    }
}
