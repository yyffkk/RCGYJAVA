package com.api.vo.butlerApp;

/**
 * 管家app 装修管理Vo list 回显
 */
public class ButlerDecorationVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产名称
     */
    private String roomName;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 操作状态(1.待指派【当检查跟踪人为null且装修状态为>1】，2.已指派（待执行）【装修状态为<5】，3.已完成【装修状态为>=5】)
     */
    private Integer operationStatus;
    /**
     * 装修状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 跟踪人id
     */
    private Integer tracker;

    @Override
    public String toString() {
        return "ButlerDecorationVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", operationStatus=" + operationStatus +
                ", status=" + status +
                ", tracker=" + tracker +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    public ButlerDecorationVo() {
    }

    public ButlerDecorationVo(Integer id, String roomName, String constructionUnit, Integer operationStatus, Integer status, Integer tracker) {
        this.id = id;
        this.roomName = roomName;
        this.constructionUnit = constructionUnit;
        this.operationStatus = operationStatus;
        this.status = status;
        this.tracker = tracker;
    }
}
