package com.api.model.butlerService;

import java.util.Date;

/**
 * 工单信息model
 */
public class DispatchList {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 工单号【创建报事报修表时，先创建该表，并生成工单号】
     */
    private String code;
    /**
     * 工单类型（取自工单类型管理）
     */
    private Integer workOrderType;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
     */
    private Integer status;
    /**
     * 创建人（录单人,app提交为 -1）
     */
    private Integer createId;
    /**
     * 创建时间（录单时间）
     */
    private Date createDate;
    /**
     * 是否删除，0删除，1非删（用户端删除）
     */
    private Integer userDelete;
    /**
     * 是否删除，0删除，1非删（系统端删除）
     */
    private Integer sysDelete;

    @Override
    public String toString() {
        return "DispatchList{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", workOrderType=" + workOrderType +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", userDelete=" + userDelete +
                ", sysDelete=" + sysDelete +
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

    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(Integer userDelete) {
        this.userDelete = userDelete;
    }

    public Integer getSysDelete() {
        return sysDelete;
    }

    public void setSysDelete(Integer sysDelete) {
        this.sysDelete = sysDelete;
    }

    public DispatchList() {
    }

    public DispatchList(Integer id, String code, Integer workOrderType, Integer status, Integer createId, Date createDate, Integer userDelete, Integer sysDelete) {
        this.id = id;
        this.code = code;
        this.workOrderType = workOrderType;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.userDelete = userDelete;
        this.sysDelete = sysDelete;
    }
}
