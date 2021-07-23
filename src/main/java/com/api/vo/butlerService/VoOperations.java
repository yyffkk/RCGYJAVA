package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 运维管理 Vo list 回显
 */
public class VoOperations {
    /**
     * 记录编号
     */
    private String code;
    /**
     * 维修设备
     */
    private String equipment;
    /**
     * 维修类别：1.大修，2.小修，3.项修
     */
    private Integer type;
    /**
     * 维修人姓名
     */
    private String people;
    /**
     * 维修用料
     */
    private String materials;
    /**
     * 维修费用（元）
     */
    private BigDecimal costs;
    /**
     * 维修单位（公司）
     */
    private String department;
    /**
     * 维修结果：1.已修复，2.部分损坏，3.未修复
     */
    private Integer results;
    /**
     * 维修用时（时）
     */
    private Integer times;
    /**
     * 备注
     */
    private String remakes;
    /**
     * 维修时间
     */
    private Date maintenanceDate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 登记人
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoOperations{" +
                "code='" + code + '\'' +
                ", equipment='" + equipment + '\'' +
                ", type=" + type +
                ", people='" + people + '\'' +
                ", materials='" + materials + '\'' +
                ", costs=" + costs +
                ", department='" + department + '\'' +
                ", results=" + results +
                ", times=" + times +
                ", remakes='" + remakes + '\'' +
                ", maintenanceDate=" + maintenanceDate +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoOperations() {
    }

    public VoOperations(String code, String equipment, Integer type, String people, String materials, BigDecimal costs, String department, Integer results, Integer times, String remakes, Date maintenanceDate, Integer createId, String createName, Date createDate) {
        this.code = code;
        this.equipment = equipment;
        this.type = type;
        this.people = people;
        this.materials = materials;
        this.costs = costs;
        this.department = department;
        this.results = results;
        this.times = times;
        this.remakes = remakes;
        this.maintenanceDate = maintenanceDate;
        this.createId = createId;
        this.createName = createName;
        this.createDate = createDate;
    }
}
