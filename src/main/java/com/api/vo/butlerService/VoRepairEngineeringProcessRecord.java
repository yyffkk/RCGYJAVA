package com.api.vo.butlerService;

import java.util.Date;

/**
 * 报事报修工程维修 Vo 处理进程记录
 */
public class VoRepairEngineeringProcessRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工程维修主键id
     */
    private Integer repairEngineeringId;
    /**
     * 操作时间（数据创建时间）
     */
    private Date operationDate;
    /**
     * 操作类型（1.提交工程维修，2.派单（维修公司），3.派单（维修人员），4.接单（维修人员），5.处理完成，6.验收驳回，7.验收通过，8.开始整改，9.作废，10.取消
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
        return "VoRepairEngineeringProcessRecord{" +
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

    public VoRepairEngineeringProcessRecord() {
    }

    public VoRepairEngineeringProcessRecord(Integer id, Integer repairEngineeringId, Date operationDate, Integer operationType, Integer operator, Integer operatorType, String operatorContent) {
        this.id = id;
        this.repairEngineeringId = repairEngineeringId;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.operator = operator;
        this.operatorType = operatorType;
        this.operatorContent = operatorContent;
    }
}
