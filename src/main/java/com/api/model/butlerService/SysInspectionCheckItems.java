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
    /**
     * 录入项（1.抄表值，2.备注）【2选1，或者不填】
     */
    private Integer type;

    @Override
    public String toString() {
        return "SysInspectionCheckItems{" +
                "id=" + id +
                ", inspectionPointId=" + inspectionPointId +
                ", name='" + name + '\'' +
                ", type=" + type +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SysInspectionCheckItems() {
    }

    public SysInspectionCheckItems(Integer id, Integer inspectionPointId, String name, Integer type) {
        this.id = id;
        this.inspectionPointId = inspectionPointId;
        this.name = name;
        this.type = type;
    }
}
