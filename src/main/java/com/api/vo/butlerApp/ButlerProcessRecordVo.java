package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 报修进程Vo list 回显
 */
public class ButlerProcessRecordVo {
    /**
     * 处理进程记录信息主键id
     */
    private Integer id;
    /**
     * 操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
     */
    private Integer operationType;
    /**
     * 操作时间(数据创建时间)
     */
    private Date operationDate;

    @Override
    public String toString() {
        return "ButlerProcessRecordVo{" +
                "id=" + id +
                ", operationType=" + operationType +
                ", operationDate=" + operationDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public ButlerProcessRecordVo() {
    }

    public ButlerProcessRecordVo(Integer id, Integer operationType, Date operationDate) {
        this.id = id;
        this.operationType = operationType;
        this.operationDate = operationDate;
    }
}
