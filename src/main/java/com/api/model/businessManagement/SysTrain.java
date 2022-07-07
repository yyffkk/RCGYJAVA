package com.api.model.businessManagement;

import java.util.Date;

/**
 * 培训信息model
 */
public class SysTrain {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 组织部门主键Id
     */
    private Integer organizationId;
    /**
     * 培训人员主键Id
     */
    private Integer trainPerson;
    /**
     * 培训时间
     */
    private Date trainDate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysTrain{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", trainPerson=" + trainPerson +
                ", trainDate=" + trainDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getTrainPerson() {
        return trainPerson;
    }

    public void setTrainPerson(Integer trainPerson) {
        this.trainPerson = trainPerson;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
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

    public SysTrain() {
    }

    public SysTrain(Integer id, Integer organizationId, Integer trainPerson, Date trainDate, Integer createId, Date createDate) {
        this.id = id;
        this.organizationId = organizationId;
        this.trainPerson = trainPerson;
        this.trainDate = trainDate;
        this.createId = createId;
        this.createDate = createDate;
    }
}
