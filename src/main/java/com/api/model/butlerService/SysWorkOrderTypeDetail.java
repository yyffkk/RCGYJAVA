package com.api.model.butlerService;

import java.util.Date;

/**
 * 工单类型明细管理
 */
public class SysWorkOrderTypeDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工单大类id
     */
    private Integer workOrderTypeId;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysWorkOrderTypeDetail{" +
                "id=" + id +
                ", workOrderTypeId=" + workOrderTypeId +
                ", name='" + name + '\'' +
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

    public Integer getWorkOrderTypeId() {
        return workOrderTypeId;
    }

    public void setWorkOrderTypeId(Integer workOrderTypeId) {
        this.workOrderTypeId = workOrderTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public SysWorkOrderTypeDetail() {
    }

    public SysWorkOrderTypeDetail(Integer id, Integer workOrderTypeId, String name, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.workOrderTypeId = workOrderTypeId;
        this.name = name;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
