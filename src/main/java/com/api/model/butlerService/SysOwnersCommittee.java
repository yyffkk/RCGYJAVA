package com.api.model.butlerService;

import java.util.Date;

/**
 * 业委会信息
 */
public class SysOwnersCommittee {
    /**
     * 业委会信息主键id
     */
    private Integer id;
    /**
     * 业主id
     */
    private Integer residentId;
    /**
     * 职位id(1.业委会主任，2.业委会副主任，3.业委会委员)
     */
    private Integer positionId;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 学历id（1.专科，2.本科，3.硕士，4.博士）
     */
    private Integer educationId;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 职业（社会职业）
     */
    private String profession;
    /**
     * 创建人
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
        return "SysOwnersCommittee{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", positionId=" + positionId +
                ", age=" + age +
                ", educationId=" + educationId +
                ", estateId=" + estateId +
                ", profession='" + profession + '\'' +
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

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public SysOwnersCommittee() {
    }

    public SysOwnersCommittee(Integer id, Integer residentId, Integer positionId, Integer age, Integer educationId, Integer estateId, String profession, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.residentId = residentId;
        this.positionId = positionId;
        this.age = age;
        this.educationId = educationId;
        this.estateId = estateId;
        this.profession = profession;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
