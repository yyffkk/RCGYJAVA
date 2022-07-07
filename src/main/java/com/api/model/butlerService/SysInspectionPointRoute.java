package com.api.model.butlerService;

/**
 * 巡检点-路线 关联表
 */
public class SysInspectionPointRoute {
    /**
     * 巡检点主键id
     */
    private Integer inspectionPointId;
    /**
     * 巡检路线主键Id
     */
    private Integer inspectionRouteId;

    @Override
    public String toString() {
        return "SysInspectionPointRoute{" +
                "inspectionPointId=" + inspectionPointId +
                ", inspectionRouteId=" + inspectionRouteId +
                '}';
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

    public SysInspectionPointRoute() {
    }

    public SysInspectionPointRoute(Integer inspectionPointId, Integer inspectionRouteId) {
        this.inspectionPointId = inspectionPointId;
        this.inspectionRouteId = inspectionRouteId;
    }
}
