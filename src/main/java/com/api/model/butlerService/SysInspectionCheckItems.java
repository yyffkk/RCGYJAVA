package com.api.model.butlerService;

/**
 * 巡检点检查项信息model
 */
public class SysInspectionCheckItems {
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 巡检点主键id
     */
    private Integer inspectionPointId;
    /**
     * 检查项名称
     */
    private String name;

    @Override
    public String toString() {
        return "SysInspectionCheckItems{" +
                "id=" + id +
                ", inspectionPointId=" + inspectionPointId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInspectionPointId() {
        return inspectionPointId;
    }

    public void setInspectionPointId(Integer inspectionPointId) {
        this.inspectionPointId = inspectionPointId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysInspectionCheckItems() {
    }

    public SysInspectionCheckItems(Integer id, Integer inspectionPointId, String name) {
        this.id = id;
        this.inspectionPointId = inspectionPointId;
        this.name = name;
    }
}
