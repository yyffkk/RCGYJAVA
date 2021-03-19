package com.api.vo.butlerService;

import java.util.Date;

/**
 * 巡检计划Vo list 回显
 */
public class VoInspectionPlan {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检计划编号
     */
    private String code;
    /**
     * 巡检路线编号
     */
    private String routeCode;
    /**
     * 巡检计划名称
     */
    private String name;
    /**
     * 计划开始时间
     */
    private Date planBeginDate;
    /**
     * 实际开始时间
     */
    private Date actualBeginDate;
    /**
     * 组织（部门）名称
     */
    private String organizationName;
    /**
     * 巡检人名称
     */
    private String inspectorName;
    /**
     * 状态，1.启用，2.停用
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoInspectionPlan{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", routeCode='" + routeCode + '\'' +
                ", name='" + name + '\'' +
                ", planBeginDate=" + planBeginDate +
                ", actualBeginDate=" + actualBeginDate +
                ", organizationName='" + organizationName + '\'' +
                ", inspectorName='" + inspectorName + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(Date planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public VoInspectionPlan() {
    }

    public VoInspectionPlan(Integer id, String code, String routeCode, String name, Date planBeginDate, Date actualBeginDate, String organizationName, String inspectorName, Integer status) {
        this.id = id;
        this.code = code;
        this.routeCode = routeCode;
        this.name = name;
        this.planBeginDate = planBeginDate;
        this.actualBeginDate = actualBeginDate;
        this.organizationName = organizationName;
        this.inspectorName = inspectorName;
        this.status = status;
    }
}
