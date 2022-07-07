package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 巡检计划 Vo list 回显
 */
public class SDSysInspectionPlanVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检路线主键id
     */
    private Integer inspectionRouteId;
    /**
     * 巡检编号
     */
    private String code;
    /**
     * 巡检计划名称
     */
    private String name;
    /**
     * 状态，1.启用 2.停用
     */
    private Integer status;
    /**
     * 部门id(组织id)
     */
    private Integer organizationId;
    /**
     * 巡检人id
     */
    private Integer inspector;
    /**
     * 计划开始时间
     */
    private Date planBeginDate;
    /**
     * 实际开始时间
     */
    private Date actualBeginDate;
    /**
     * 是否按顺序巡检（1.顺序，2.不顺序）
     */
    private Integer isSort;
    /**
     * 检查频率【类型】类型：1.每天，2.每周，3.每月
     */
    private Integer checkRateType;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 是否删除，1.非删，0.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SDSysInspectionPlanVo{" +
                "id=" + id +
                ", inspectionRouteId=" + inspectionRouteId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", organizationId=" + organizationId +
                ", inspector=" + inspector +
                ", planBeginDate=" + planBeginDate +
                ", actualBeginDate=" + actualBeginDate +
                ", isSort=" + isSort +
                ", checkRateType=" + checkRateType +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInspectionRouteId() {
        return inspectionRouteId;
    }

    public void setInspectionRouteId(Integer inspectionRouteId) {
        this.inspectionRouteId = inspectionRouteId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getInspector() {
        return inspector;
    }

    public void setInspector(Integer inspector) {
        this.inspector = inspector;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public SDSysInspectionPlanVo() {
    }

    public SDSysInspectionPlanVo(Integer id, Integer inspectionRouteId, String code, String name, Integer status, Integer organizationId, Integer inspector, Date planBeginDate, Date actualBeginDate, Integer isSort, Integer checkRateType, Integer createId, Date createDate, Integer isDelete) {
        this.id = id;
        this.inspectionRouteId = inspectionRouteId;
        this.code = code;
        this.name = name;
        this.status = status;
        this.organizationId = organizationId;
        this.inspector = inspector;
        this.planBeginDate = planBeginDate;
        this.actualBeginDate = actualBeginDate;
        this.isSort = isSort;
        this.checkRateType = checkRateType;
        this.createId = createId;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }
}
