package com.api.vo.butlerService;

import java.util.Date;

/**
 * 派工单管理Vo list 回显
 */
public class VoDispatchList {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工单类型（取自工单类型管理）
     */
    private String workOrderTypeName;
    /**
     * 工单号
     */
    private String code;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
     */
    private Integer status;
    /**
     * 派工时间【可能为空】
     */
    private Date dispatchDate;
    /**
     * 工单时限（取自工单时限管理）【可能为空】
     */
    private Integer workOrderTimeLimit;
    /**
     * 提交人姓名（报修人）
     */
    private String createName;
    /**
     * 提交人电话（报修人电话）
     */
    private String tel;
    /**
     * 操作人姓名（维修人）【可能为空】
     */
    private String operatorName;
    /**
     * 操作地点（房屋信息）
     */
    private String roomName;
    /**
     * 要求处理事项（报修事项）
     */
    private String reportDetail;
    /**
     * 派工备注【可能为空】
     */
    private String remake;
    /**
     * 开始处理时间【可能为空】
     */
    private Date beginDate;
    /**
     * 回访时间【可能为空】
     */
    private Date revisitDate;
    /**
     * 回访情况说明【可能为空】
     */
    private String revisitDetail;

    @Override
    public String toString() {
        return "VoDispatchList{" +
                "id=" + id +
                ", workOrderTypeName='" + workOrderTypeName + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", dispatchDate=" + dispatchDate +
                ", workOrderTimeLimit=" + workOrderTimeLimit +
                ", createName='" + createName + '\'' +
                ", tel='" + tel + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", reportDetail='" + reportDetail + '\'' +
                ", remake='" + remake + '\'' +
                ", beginDate=" + beginDate +
                ", revisitDate=" + revisitDate +
                ", revisitDetail='" + revisitDetail + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkOrderTypeName() {
        return workOrderTypeName;
    }

    public void setWorkOrderTypeName(String workOrderTypeName) {
        this.workOrderTypeName = workOrderTypeName;
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

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Integer getWorkOrderTimeLimit() {
        return workOrderTimeLimit;
    }

    public void setWorkOrderTimeLimit(Integer workOrderTimeLimit) {
        this.workOrderTimeLimit = workOrderTimeLimit;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getRevisitDate() {
        return revisitDate;
    }

    public void setRevisitDate(Date revisitDate) {
        this.revisitDate = revisitDate;
    }

    public String getRevisitDetail() {
        return revisitDetail;
    }

    public void setRevisitDetail(String revisitDetail) {
        this.revisitDetail = revisitDetail;
    }

    public VoDispatchList() {
    }

    public VoDispatchList(Integer id, String workOrderTypeName, String code, Integer status, Date dispatchDate, Integer workOrderTimeLimit, String createName, String tel, String operatorName, String roomName, String reportDetail, String remake, Date beginDate, Date revisitDate, String revisitDetail) {
        this.id = id;
        this.workOrderTypeName = workOrderTypeName;
        this.code = code;
        this.status = status;
        this.dispatchDate = dispatchDate;
        this.workOrderTimeLimit = workOrderTimeLimit;
        this.createName = createName;
        this.tel = tel;
        this.operatorName = operatorName;
        this.roomName = roomName;
        this.reportDetail = reportDetail;
        this.remake = remake;
        this.beginDate = beginDate;
        this.revisitDate = revisitDate;
        this.revisitDetail = revisitDetail;
    }
}
