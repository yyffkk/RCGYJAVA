package com.api.model.butlerService;

/**
 * 更改工单状态信息
 */
public class UpdateDispatchStatus {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 工单状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "UpdateDispatchStatus{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UpdateDispatchStatus() {
    }

    public UpdateDispatchStatus(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }
}
