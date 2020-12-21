package com.api.vo.butlerService;

import java.util.Date;

/**
 * 报事报修Vo list 回显
 */
public class VoReportRepair {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 报修单号
     */
    private String code;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
     */
    private Integer status;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 报修人
     */
    private String repairmanName;
    /**
     * 报修人电话
     */
    private String repairTel;
    /**
     * 报修时间
     */
    private Date repairDate;
    /**
     * 分配人
     */
    private String distributorName;
    /**
     * 维修人
     */
    private String operatorName;
    /**
     * 工单时限
     */
    private String workOrderTimeLimit;
    /**
     * 来源
     */
    private String fromsName;

    @Override
    public String toString() {
        return "VoReportRepair{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", roomName='" + roomName + '\'' +
                ", repairmanName='" + repairmanName + '\'' +
                ", repairTel='" + repairTel + '\'' +
                ", repairDate=" + repairDate +
                ", distributorName='" + distributorName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", workOrderTimeLimit='" + workOrderTimeLimit + '\'' +
                ", fromsName='" + fromsName + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRepairmanName() {
        return repairmanName;
    }

    public void setRepairmanName(String repairmanName) {
        this.repairmanName = repairmanName;
    }

    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getWorkOrderTimeLimit() {
        return workOrderTimeLimit;
    }

    public void setWorkOrderTimeLimit(String workOrderTimeLimit) {
        this.workOrderTimeLimit = workOrderTimeLimit;
    }

    public String getFromsName() {
        return fromsName;
    }

    public void setFromsName(String fromsName) {
        this.fromsName = fromsName;
    }

    public VoReportRepair() {
    }

    public VoReportRepair(Integer id, String code, Integer status, String roomName, String repairmanName, String repairTel, Date repairDate, String distributorName, String operatorName, String workOrderTimeLimit, String fromsName) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.roomName = roomName;
        this.repairmanName = repairmanName;
        this.repairTel = repairTel;
        this.repairDate = repairDate;
        this.distributorName = distributorName;
        this.operatorName = operatorName;
        this.workOrderTimeLimit = workOrderTimeLimit;
        this.fromsName = fromsName;
    }
}
