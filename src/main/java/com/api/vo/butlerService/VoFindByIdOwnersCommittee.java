package com.api.vo.butlerService;

/**
 * 业委会管理Vo findById 回显
 */
public class VoFindByIdOwnersCommittee {
    /**
     * 业委会信息主键id
     */
    private Integer id;
    /**
     * 业主id（前端隐藏）
     */
    private Integer residentId;
    /**
     * 业主姓名
     */
    private String name;
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
     * 单元id
     */
    private Integer unitId;
    /**
     * 楼栋id
     */
    private Integer buildingId;
    /**
     * 职业（社会职业）
     */
    private String profession;

    @Override
    public String toString() {
        return "VoFindByIdOwnersCommittee{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", name='" + name + '\'' +
                ", positionId=" + positionId +
                ", age=" + age +
                ", educationId=" + educationId +
                ", estateId=" + estateId +
                ", unitId=" + unitId +
                ", buildingId=" + buildingId +
                ", profession='" + profession + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public VoFindByIdOwnersCommittee() {
    }

    public VoFindByIdOwnersCommittee(Integer id, Integer residentId, String name, Integer positionId, Integer age, Integer educationId, Integer estateId, Integer unitId, Integer buildingId, String profession) {
        this.id = id;
        this.residentId = residentId;
        this.name = name;
        this.positionId = positionId;
        this.age = age;
        this.educationId = educationId;
        this.estateId = estateId;
        this.unitId = unitId;
        this.buildingId = buildingId;
        this.profession = profession;
    }
}
