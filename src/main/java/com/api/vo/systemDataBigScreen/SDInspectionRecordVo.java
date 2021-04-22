package com.api.vo.systemDataBigScreen;

import java.util.Date;
import java.util.List;

/**
 * 系统数据 巡更记录回显
 */
public class SDInspectionRecordVo {
    /**
     * 巡检执行计划主键id
     */
    private Integer id;
    /**
     * 巡更计划名称
     */
    private String name;
    /**
     * 巡更点集合
     */
    private List<SDInspectionExecutePointVo> PointVoList;
    /**
     * 巡更人员名称
     */
    private String inspector;
    /**
     * 计划当次巡检开始时间
     */
    private Date beginDate;
    /**
     * 计划当次巡检结束时间
     */
    private Date endDate;
    /**
     * 实际当次巡检开始时间
     */
    private Date actualBeginDate;
    /**
     * 实际当次巡检结束时间
     */
    private Date actualEndDate;

    @Override
    public String toString() {
        return "SDInspectionRecordVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PointVoList=" + PointVoList +
                ", inspector='" + inspector + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SDInspectionExecutePointVo> getPointVoList() {
        return PointVoList;
    }

    public void setPointVoList(List<SDInspectionExecutePointVo> pointVoList) {
        PointVoList = pointVoList;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public SDInspectionRecordVo() {
    }

    public SDInspectionRecordVo(Integer id, String name, List<SDInspectionExecutePointVo> pointVoList, String inspector, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate) {
        this.id = id;
        this.name = name;
        PointVoList = pointVoList;
        this.inspector = inspector;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
    }
}
