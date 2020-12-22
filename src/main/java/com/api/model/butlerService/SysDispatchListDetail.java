package com.api.model.butlerService;

import java.util.Date;

/**
 * 派工单详情信息
 */
public class SysDispatchListDetail {
    /**
     * 派工单详情表主键id
     */
    private Integer id;
    /**
     * 订单号
     */
    private String code;
    /**
     * 派工单id
     */
    private Integer dispatchListId;
    /**
     * 工单类型（取自工单类型管理）
     */
    private Integer workOrderType;
    /**
     * 工单类型明细（取自工单类型明细管理）
     */
    private Integer workOrderTypeDetail;
    /**
     * 工单时限（取自工单时限管理）
     */
    private Integer workOrderTimeLimit;
    /**
     * 派工类型（1.无偿服务，2.有偿服务）
     */
    private Integer type;
    /**
     * 派工时间
     */
    private Date dispatchDate;
    /**
     * 操作人【装修人】（物业表）
     */
    private Integer operator;
    /**
     * 派工备注
     */
    private String remake;
    /**
     * 创建人（分配人）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysDispatchListDetail{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", dispatchListId=" + dispatchListId +
                ", workOrderType=" + workOrderType +
                ", workOrderTypeDetail=" + workOrderTypeDetail +
                ", workOrderTimeLimit=" + workOrderTimeLimit +
                ", type=" + type +
                ", dispatchDate=" + dispatchDate +
                ", operator=" + operator +
                ", remake='" + remake + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
    }

    public Integer getWorkOrderTypeDetail() {
        return workOrderTypeDetail;
    }

    public void setWorkOrderTypeDetail(Integer workOrderTypeDetail) {
        this.workOrderTypeDetail = workOrderTypeDetail;
    }

    public Integer getWorkOrderTimeLimit() {
        return workOrderTimeLimit;
    }

    public void setWorkOrderTimeLimit(Integer workOrderTimeLimit) {
        this.workOrderTimeLimit = workOrderTimeLimit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysDispatchListDetail() {
    }

    public SysDispatchListDetail(Integer id, String code, Integer dispatchListId, Integer workOrderType, Integer workOrderTypeDetail, Integer workOrderTimeLimit, Integer type, Date dispatchDate, Integer operator, String remake, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.code = code;
        this.dispatchListId = dispatchListId;
        this.workOrderType = workOrderType;
        this.workOrderTypeDetail = workOrderTypeDetail;
        this.workOrderTimeLimit = workOrderTimeLimit;
        this.type = type;
        this.dispatchDate = dispatchDate;
        this.operator = operator;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
