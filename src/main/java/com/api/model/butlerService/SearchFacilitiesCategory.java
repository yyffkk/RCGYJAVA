package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施分类搜索条件
 */
public class SearchFacilitiesCategory {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 设施分类名称
     */
    private String name;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 添加开始时间
     */
    private Date createStartDate;
    /**
     * 添加结束时间
     */
    private Date createEndDate;

    @Override
    public String toString() {
        return "SearchFacilitiesCategory{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", createStartDate=" + createStartDate +
                ", createEndDate=" + createEndDate +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateStartDate() {
        return createStartDate;
    }

    public void setCreateStartDate(Date createStartDate) {
        this.createStartDate = createStartDate;
    }

    public Date getCreateEndDate() {
        return createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    public SearchFacilitiesCategory() {
    }

    public SearchFacilitiesCategory(int pageNum, int size, String name, String code, Date createStartDate, Date createEndDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.code = code;
        this.createStartDate = createStartDate;
        this.createEndDate = createEndDate;
    }
}
