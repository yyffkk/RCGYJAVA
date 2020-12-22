package com.api.vo.butlerService;

import java.util.Date;

/**
 * 派工详情
 */
public class VoDispatch {
    /**
     * 派工单详情表主键id
     */
    private Integer id;
    /**
     * 派工订单号
     */
    private String code;
    /**
     * 工单时限（取自工单时限管理）
     */
    private String workOrderTimeLimitName;
    /**
     * 操作人【装修人】（物业表）
     */
    private String operatorName;
    /**
     * 工单类型（取自工单类型管理）
     */
    private String workOrderTypeName;
    /**
     * 工单类型明细（取自工单类型明细管理）
     */
    private String workOrderTypeDetailName;
    /**
     * 派工时间
     */
    private Date dispatchDate;
    /**
     * 派工备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoDispatch{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", workOrderTimeLimitName='" + workOrderTimeLimitName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", workOrderTypeName='" + workOrderTypeName + '\'' +
                ", workOrderTypeDetailName='" + workOrderTypeDetailName + '\'' +
                ", dispatchDate=" + dispatchDate +
                ", remake='" + remake + '\'' +
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

    public String getWorkOrderTimeLimitName() {
        return workOrderTimeLimitName;
    }

    public void setWorkOrderTimeLimitName(String workOrderTimeLimitName) {
        this.workOrderTimeLimitName = workOrderTimeLimitName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getWorkOrderTypeName() {
        return workOrderTypeName;
    }

    public void setWorkOrderTypeName(String workOrderTypeName) {
        this.workOrderTypeName = workOrderTypeName;
    }

    public String getWorkOrderTypeDetailName() {
        return workOrderTypeDetailName;
    }

    public void setWorkOrderTypeDetailName(String workOrderTypeDetailName) {
        this.workOrderTypeDetailName = workOrderTypeDetailName;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoDispatch() {
    }

    public VoDispatch(Integer id, String code, String workOrderTimeLimitName, String operatorName, String workOrderTypeName, String workOrderTypeDetailName, Date dispatchDate, String remake) {
        this.id = id;
        this.code = code;
        this.workOrderTimeLimitName = workOrderTimeLimitName;
        this.operatorName = operatorName;
        this.workOrderTypeName = workOrderTypeName;
        this.workOrderTypeDetailName = workOrderTypeDetailName;
        this.dispatchDate = dispatchDate;
        this.remake = remake;
    }
}
