package com.api.vo.operationManagement;

/**
 * 物资盘点详情管理 Vo list 回显
 */
public class VoMaterialInventoryDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 物资盘点主键id
     */
    private Integer materialInventoryId;
    /**
     * 物资名称
     */
    private String name;
    /**
     * 单位
     */
    private String unit;
    /**
     * 应有库存
     */
    private Integer shouldInventory;
    /**
     * 实际库存
     */
    private Integer actualInventory;
    /**
     * 盘盈盘亏，正数盈，负数亏
     */
    private Integer inventorySurplusLosses;

    @Override
    public String toString() {
        return "VoMaterialInventoryDetail{" +
                "id=" + id +
                ", materialInventoryId=" + materialInventoryId +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", shouldInventory=" + shouldInventory +
                ", actualInventory=" + actualInventory +
                ", inventorySurplusLosses=" + inventorySurplusLosses +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialInventoryId() {
        return materialInventoryId;
    }

    public void setMaterialInventoryId(Integer materialInventoryId) {
        this.materialInventoryId = materialInventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getShouldInventory() {
        return shouldInventory;
    }

    public void setShouldInventory(Integer shouldInventory) {
        this.shouldInventory = shouldInventory;
    }

    public Integer getActualInventory() {
        return actualInventory;
    }

    public void setActualInventory(Integer actualInventory) {
        this.actualInventory = actualInventory;
    }

    public Integer getInventorySurplusLosses() {
        return inventorySurplusLosses;
    }

    public void setInventorySurplusLosses(Integer inventorySurplusLosses) {
        this.inventorySurplusLosses = inventorySurplusLosses;
    }

    public VoMaterialInventoryDetail() {
    }

    public VoMaterialInventoryDetail(Integer id, Integer materialInventoryId, String name, String unit, Integer shouldInventory, Integer actualInventory, Integer inventorySurplusLosses) {
        this.id = id;
        this.materialInventoryId = materialInventoryId;
        this.name = name;
        this.unit = unit;
        this.shouldInventory = shouldInventory;
        this.actualInventory = actualInventory;
        this.inventorySurplusLosses = inventorySurplusLosses;
    }
}
