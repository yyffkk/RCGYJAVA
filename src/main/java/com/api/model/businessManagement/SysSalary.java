package com.api.model.businessManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 薪资信息model
 */
public class SysSalary {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 组织部门主键Id
     */
    private Integer organizationId;
    /**
     * 薪资人员主键Id
     */
    private Integer salaryPerson;
    /**
     * 工资卡号
     */
    private String wageCardNumber;
    /**
     * 薪资
     */
    private BigDecimal salary;
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
        return "SysSalary{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", salaryPerson=" + salaryPerson +
                ", wageCardNumber='" + wageCardNumber + '\'' +
                ", salary=" + salary +
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

    public Integer getSalaryPerson() {
        return salaryPerson;
    }

    public void setSalaryPerson(Integer salaryPerson) {
        this.salaryPerson = salaryPerson;
    }

    public String getWageCardNumber() {
        return wageCardNumber;
    }

    public void setWageCardNumber(String wageCardNumber) {
        this.wageCardNumber = wageCardNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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

    public SysSalary() {
    }

    public SysSalary(Integer id, Integer organizationId, Integer salaryPerson, String wageCardNumber, BigDecimal salary, Integer createId, Date createDate) {
        this.id = id;
        this.organizationId = organizationId;
        this.salaryPerson = salaryPerson;
        this.wageCardNumber = wageCardNumber;
        this.salary = salary;
        this.createId = createId;
        this.createDate = createDate;
    }
}
