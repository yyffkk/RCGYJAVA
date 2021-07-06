package com.api.vo.systemDataBigScreen;

/**
 * 巡检路线-点关联表 Vo list 回显
 */
public class SDSysInspectionPointRouteVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检点主键id
     */
    private Integer inspectionPointId;
    /**
     * 巡检路线主键id
     */
    private Integer inspectionRouteId;

    @Override
    public String toString() {
        return "SDSysInspectionPointRoute{" +
                "id=" + id +
                ", inspectionPointId=" + inspectionPointId +
                ", inspectionRouteId=" + inspectionRouteId +
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

    public Integer getInspectionRouteId() {
        return inspectionRouteId;
    }

    public void setInspectionRouteId(Integer inspectionRouteId) {
        this.inspectionRouteId = inspectionRouteId;
    }

    public SDSysInspectionPointRouteVo() {
    }

    public SDSysInspectionPointRouteVo(Integer id, Integer inspectionPointId, Integer inspectionRouteId) {
        this.id = id;
        this.inspectionPointId = inspectionPointId;
        this.inspectionRouteId = inspectionRouteId;
    }
}
