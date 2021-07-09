package com.api.model.app;

import java.util.Date;

/**
 * app 新版家政服务处理进程记录
 */
public class AppHousekeepingServiceProcessRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 新版家政服务主键id
     */
    private Integer housekeepingServiceId;
    /**
     * 操作时间(数据创建时间)
     */
    private Date operationDate;
    /**
     * 操作类型（1.提交家政，2.派单，3.开始处理，4.处理完成，5.已确认支付，6.评价，8.作废，9.取消,10.改派）
     */
    private Integer operationType;
    /**
     * 操作人（取自住户表或物业表）
     */
    private Integer operator;
    /**
     * 操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
     */
    private Integer operatorType;
    /**
     * 操作内容
     */
    private String operatorContent;

    @Override
    public String toString() {
        return "AppHousekeepingServiceProcessRecord{" +
                "id=" + id +
                ", housekeepingServiceId=" + housekeepingServiceId +
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

    public Integer getHousekeepingServiceId() {
        return housekeepingServiceId;
    }

    public void setHousekeepingServiceId(Integer housekeepingServiceId) {
        this.housekeepingServiceId = housekeepingServiceId;
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

    public AppHousekeepingServiceProcessRecord() {
    }

    public AppHousekeepingServiceProcessRecord(Integer id, Integer housekeepingServiceId, Date operationDate, Integer operationType, Integer operator, Integer operatorType, String operatorContent) {
        this.id = id;
        this.housekeepingServiceId = housekeepingServiceId;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.operator = operator;
        this.operatorType = operatorType;
        this.operatorContent = operatorContent;
    }
}
