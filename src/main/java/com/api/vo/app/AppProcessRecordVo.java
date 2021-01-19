package com.api.vo.app;

import java.util.Date;

/**
 * app进程处理
 */
public class AppProcessRecordVo {
    /**
     * 操作时间(数据创建时间)
     */
    private Date operationDate;
    /**
     * 操作类型（1.提交报修(报修时间)，2.派单(管家分派时间)，3.开始处理(师傅接单)，4.处理完成，5.确认，6.回访(回访)，7.回退，8.作废，9.取消）
     */
    private Integer operationType;

    @Override
    public String toString() {
        return "AppProcessRecordVo{" +
                "operationDate=" + operationDate +
                ", operationType=" + operationType +
                '}';
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

    public AppProcessRecordVo() {
    }

    public AppProcessRecordVo(Date operationDate, Integer operationType) {
        this.operationDate = operationDate;
        this.operationType = operationType;
    }
}
