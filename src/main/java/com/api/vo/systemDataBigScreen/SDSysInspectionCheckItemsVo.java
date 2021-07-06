package com.api.vo.systemDataBigScreen;

/**
 * 巡检执行点检查项Vo list 回显
 */
public class SDSysInspectionCheckItemsVo {
    /**
     * 主键id
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
        return "SDSysInspectionCheckItemsVo{" +
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

    public SDSysInspectionCheckItemsVo() {
    }

    public SDSysInspectionCheckItemsVo(Integer id, Integer inspectionPointId, String name) {
        this.id = id;
        this.inspectionPointId = inspectionPointId;
        this.name = name;
    }
}
