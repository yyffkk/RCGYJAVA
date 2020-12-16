package com.api.model.butlerService;

import java.util.Date;

/**
 * 工单时限管理表
 */
public class SysWorkOrderTimeLimit {
    /**
     * 工单时限管理主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 工单处理时限
     */
    private Integer timeLimit;
    /**
     * 备注
     */
    private String remake;
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
        return "SysWorkOrderTimeLimit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeLimit=" + timeLimit +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
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

    public SysWorkOrderTimeLimit() {
    }

    public SysWorkOrderTimeLimit(Integer id, String name, Integer timeLimit, String remake, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.timeLimit = timeLimit;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
