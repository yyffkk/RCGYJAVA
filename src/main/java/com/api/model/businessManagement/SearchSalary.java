package com.api.model.businessManagement;

/**
 * 薪资管理搜索条件
 */
public class SearchSalary {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 部门主键id
     */
    private Integer organizationId;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 工资卡号
     */
    private String wageCardNumber;

    @Override
    public String toString() {
        return "SearchSalary{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", organizationId=" + organizationId +
                ", tel='" + tel + '\'' +
                ", wageCardNumber='" + wageCardNumber + '\'' +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public SearchSalary() {
    }

    public SearchSalary(int pageNum, int size, Integer organizationId, String tel, String wageCardNumber) {
        this.pageNum = pageNum;
        this.size = size;
        this.organizationId = organizationId;
        this.tel = tel;
        this.wageCardNumber = wageCardNumber;
    }
}
