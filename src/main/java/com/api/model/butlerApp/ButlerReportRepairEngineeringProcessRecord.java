package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 报事报修工程维修进程model
 */
public class ButlerReportRepairEngineeringProcessRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工程维修主键id
     */
    private Integer repairEngineeringId;
    /**
     * 操作时间(数据创建时间)
     */
    private Date operationDate;
    /**
     * 操作类型（1.提交工程维修，2.派单（维修公司），3.派单（维修人员），4.接单（维修人员），5.处理完成，8.作废，9.取消
     */
    private Integer operationType;
    /**
     * 操作人（取自住户表或物业表）
     */
    private Integer operator;
    /**
     * 操作人类型（1.住户，2.管家（物业）【后台提交时存在该类型】,3.操作人（物业））
     */
    private Integer operatorType;
    /**
     * 操作内容
     */
    private String operatorContent;

    @Override
    public String toString() {
        return "ButlerReportRepairEngineeringProcessRecord{" +
                "id=" + id +
                ", repairEngineeringId=" + repairEngineeringId +
                ", operationDate=" + operationDate +
                ", operationType=" + operationType +
                ", operator=" + operator +
                ", operatorType=" + operatorType +
                ", operatorContent='" + operatorContent + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairEngineeringId() {
        return repairEngineeringId;
    }

    public void setRepairEngineeringId(Integer repairEngineeringId) {
        this.repairEngineeringId = repairEngineeringId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorContent() {
        return operatorContent;
    }

    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent;
    }

    public ButlerReportRepairEngineeringProcessRecord() {
    }

    public ButlerReportRepairEngineeringProcessRecord(Integer id, Integer repairEngineeringId, Date operationDate, Integer operationType, Integer operator, Integer operatorType, String operatorContent) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.operator = operator;
        this.operatorType = operatorType;
        this.operatorContent = operatorContent;
    }
}
