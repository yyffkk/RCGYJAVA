package com.api.vo.butlerService;

import com.api.vo.systemDataBigScreen.SDInspectionExecuteMapVo;
import com.api.vo.systemDataBigScreen.SDInspectionExecutePointVo;

import java.util.Date;
import java.util.List;

/**
 * 巡检执行情况Vo list 回显
 */
public class VoInspectionExecute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 执行巡检编号（巡检计划编号+序号）
     */
    private String code;
    /**
     * 执行巡检名称（巡检计划名称）
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
     * 状态（1.待巡检（实际当次巡检结束时间为null），2.已巡检(实际当次巡检结束时间不为null),
     * 3.巡检中(实际开始时间不为null,实际结束时间为null),4.未巡检(实际开始时间为null,实际结束时间不为null)）
     */
    private Integer status;
    /**
     * 巡检人姓名
     */
    private String inspectorName;
    /**
     * 巡检人手机号
     */
    private String inspectorTel;
    /**
     * 巡检点信息集合
     */
    private List<SDInspectionExecutePointVo> executePointVos;
    /**
     * 巡更执行路线经纬度集合
     */
    private List<SDInspectionExecuteMapVo> executeMapVos;

    @Override
    public String toString() {
        return "VoInspectionExecute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                ", status=" + status +
                ", inspectorName='" + inspectorName + '\'' +
                ", inspectorTel='" + inspectorTel + '\'' +
                ", executePointVos=" + executePointVos +
                ", executeMapVos=" + executeMapVos +
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

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getInspectorTel() {
        return inspectorTel;
    }

    public void setInspectorTel(String inspectorTel) {
        this.inspectorTel = inspectorTel;
    }

    public List<SDInspectionExecutePointVo> getExecutePointVos() {
        return executePointVos;
    }

    public void setExecutePointVos(List<SDInspectionExecutePointVo> executePointVos) {
        this.executePointVos = executePointVos;
    }

    public List<SDInspectionExecuteMapVo> getExecuteMapVos() {
        return executeMapVos;
    }

    public void setExecuteMapVos(List<SDInspectionExecuteMapVo> executeMapVos) {
        this.executeMapVos = executeMapVos;
    }

    public VoInspectionExecute() {
    }

    public VoInspectionExecute(Integer id, String code, String name, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate, Integer status, String inspectorName, String inspectorTel, List<SDInspectionExecutePointVo> executePointVos, List<SDInspectionExecuteMapVo> executeMapVos) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
        this.status = status;
        this.inspectorName = inspectorName;
        this.inspectorTel = inspectorTel;
        this.executePointVos = executePointVos;
        this.executeMapVos = executeMapVos;
    }
}
