package com.api.vo.businessManagement;

import java.math.BigDecimal;

/**
 * 薪资管理Vo list 回显
 */
public class VoSalary {
    /**
     * 薪资主键id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 工资卡号
     */
    private String wageCardNumber;
    /**
     * 薪资
     */
    private BigDecimal salary;

    @Override
    public String toString() {
        return "VoSalary{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", wageCardNumber='" + wageCardNumber + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public VoSalary() {
    }

    public VoSalary(Integer id, String organizationName, String name, Integer sex, String tel, String wageCardNumber, BigDecimal salary) {
        this.id = id;
        this.organizationName = organizationName;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.wageCardNumber = wageCardNumber;
        this.salary = salary;
    }
}
