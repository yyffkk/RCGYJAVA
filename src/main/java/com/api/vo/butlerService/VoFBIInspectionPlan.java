package com.api.vo.butlerService;

import java.util.Date;

/**
 * 巡检计划Vo findById 回显
 */
public class VoFBIInspectionPlan {
    /**
     * 巡检计划主键id
     */
    private Integer id;
    /**
     * 巡检路线名称
     */
    private String routeName;
    /**
     * 巡检路线编号
     */
    private String routeCode;
    /**
     * 巡检路线主键id
     */
    private Integer routeId;
    /**
     * 巡检计划名称
     */
    private String name;
    /**
     * 组织名称（部门名称）
     */
    private String organizationName;
    /**
     * 组织id（部门id）
     */
    private Integer organizationId;
    /**
     * 巡检人姓名
     */
    private String inspectorName;
    /**
     * 巡检人主键id
     */
    private Integer inspectorId;
    /**
     * 计划开始时间
     */
    private Date planBeginDate;
    /**
     * 是否按顺序巡检（1.顺序，2.不顺序）
     */
    private Integer isSort;
    /**
     * 检查频率【类型】类型：1.每天，2.每周，3.每月
     */
    private Integer checkRateType;

    @Override
    public String toString() {
        return "VoFBIInspectionPlan{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                ", routeCode='" + routeCode + '\'' +
                ", routeId=" + routeId +
                ", name='" + name + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", organizationId=" + organizationId +
                ", inspectorName='" + inspectorName + '\'' +
                ", inspectorId=" + inspectorId +
                ", planBeginDate=" + planBeginDate +
                ", isSort=" + isSort +
                ", checkRateType=" + checkRateType +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public Integer getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Integer inspectorId) {
        this.inspectorId = inspectorId;
    }

    public Date getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(Date planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public Integer getIsSort() {
        return isSort;
    }

    public void setIsSort(Integer isSort) {
        this.isSort = isSort;
    }

    public Integer getCheckRateType() {
        return checkRateType;
    }

    public void setCheckRateType(Integer checkRateType) {
        this.checkRateType = checkRateType;
    }

    public VoFBIInspectionPlan() {
    }

    public VoFBIInspectionPlan(Integer id, String routeName, String routeCode, Integer routeId, String name, String organizationName, Integer organizationId, String inspectorName, Integer inspectorId, Date planBeginDate, Integer isSort, Integer checkRateType) {
        this.id = id;
        this.routeName = routeName;
        this.routeCode = routeCode;
        this.routeId = routeId;
        this.name = name;
        this.organizationName = organizationName;
        this.organizationId = organizationId;
        this.inspectorName = inspectorName;
        this.inspectorId = inspectorId;
        this.planBeginDate = planBeginDate;
        this.isSort = isSort;
        this.checkRateType = checkRateType;
    }
}
