package com.api.model.butlerService;

import java.util.Date;

/**
 * 处理进程记录信息
 */
public class ProcessRecord {
    /**
     * 处理进程记录信息主键id
     */
    private Integer id;
    /**
     * 工单主键id
     */
    private Integer dispatchListId;
    /**
     * 操作时间(数据创建时间)
     */
    private Date operationDate;
    /**
     * 操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
     */
    private Integer operationType;
    /**
     * 操作人（取自住户表或物业表）
     */
    private Integer operator;
    /**
     * 操作人类型（1.住户，2.物业）
     */
    private Integer operatorType;
    /**
     * 操作内容
     */
    private String operatorContent;

    @Override
    public String toString() {
        return "ProcessRecord{" +
                "id=" + id +
                ", dispatchListId=" + dispatchListId +
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

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
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

    public ProcessRecord() {
    }

    public ProcessRecord(Integer id, Integer dispatchListId, Date operationDate, Integer operationType, Integer operator, Integer operatorType, String operatorContent) {
        this.id = id;
        this.dispatchListId = dispatchListId;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.operator = operator;
        this.operatorType = operatorType;
        this.operatorContent = operatorContent;
    }
}
