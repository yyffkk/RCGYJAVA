package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 巡更执行计划 Vo list 回显
 */
public class SDInspectionExecuteListVo {
    /**
     * 巡检执行计划主键id
     */
    private Integer id;
    /**
     * 巡检计划名称
     */
    private String name;
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
    /**
     * 巡检状态（1.待巡检，2.已巡检，3.巡检中，4.未巡检）
     */
    private Integer status;

    @Override
    public String toString() {
        return "SDInspectionExecuteListVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SDInspectionExecuteListVo() {
    }

    public SDInspectionExecuteListVo(Integer id, String name, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate, Integer status) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
        this.status = status;
    }
}
