package com.api.model.businessManagement;

/**
 * 合同管理搜索条件
 */
public class SearchContract {
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

    @Override
    public String toString() {
        return "SearchContract{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", organizationId=" + organizationId +
                ", tel='" + tel + '\'' +
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

    public SearchContract() {
    }

    public SearchContract(int pageNum, int size, Integer organizationId, String tel) {
        this.pageNum = pageNum;
        this.size = size;
        this.organizationId = organizationId;
        this.tel = tel;
    }
}
