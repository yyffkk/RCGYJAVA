package com.api.model.butlerService;

import java.util.Date;

/**
 * 巡检计划 搜索条件
 */
public class SearchInspectionPlan {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
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
     * 巡检路线主键id
     */
    private Integer inspectionRouteId;
    /**
     * 计划开始时间开始
     */
    private Date planBeginDateStart;
    /**
     * 计划开始时间结束
     */
    private Date planBeginDateEnd;
    /**
     * 实际开始时间开始
     */
    private Date actualBeginDateStart;
    /**
     * 实际开始时间结束
     */
    private Date actualBeginDateEnd;

    @Override
    public String toString() {
        return "SearchInspectionPlan{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", inspectionRouteId=" + inspectionRouteId +
                ", planBeginDateStart=" + planBeginDateStart +
                ", planBeginDateEnd=" + planBeginDateEnd +
                ", actualBeginDateStart=" + actualBeginDateStart +
                ", actualBeginDateEnd=" + actualBeginDateEnd +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public Integer getInspectionRouteId() {
        return inspectionRouteId;
    }

    public void setInspectionRouteId(Integer inspectionRouteId) {
        this.inspectionRouteId = inspectionRouteId;
    }

    public Date getPlanBeginDateStart() {
        return planBeginDateStart;
    }

    public void setPlanBeginDateStart(Date planBeginDateStart) {
        this.planBeginDateStart = planBeginDateStart;
    }

    public Date getPlanBeginDateEnd() {
        return planBeginDateEnd;
    }

    public void setPlanBeginDateEnd(Date planBeginDateEnd) {
        this.planBeginDateEnd = planBeginDateEnd;
    }

    public Date getActualBeginDateStart() {
        return actualBeginDateStart;
    }

    public void setActualBeginDateStart(Date actualBeginDateStart) {
        this.actualBeginDateStart = actualBeginDateStart;
    }

    public Date getActualBeginDateEnd() {
        return actualBeginDateEnd;
    }

    public void setActualBeginDateEnd(Date actualBeginDateEnd) {
        this.actualBeginDateEnd = actualBeginDateEnd;
    }

    public SearchInspectionPlan() {
    }

    public SearchInspectionPlan(int pageNum, int size, String code, String name, Integer status, Integer inspectionRouteId, Date planBeginDateStart, Date planBeginDateEnd, Date actualBeginDateStart, Date actualBeginDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.name = name;
        this.status = status;
        this.inspectionRouteId = inspectionRouteId;
        this.planBeginDateStart = planBeginDateStart;
        this.planBeginDateEnd = planBeginDateEnd;
        this.actualBeginDateStart = actualBeginDateStart;
        this.actualBeginDateEnd = actualBeginDateEnd;
    }
}
