package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施管理 搜索条件
 */
public class SearchFacilitiesManage {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施分类主键id
     */
    private Integer facilitiesCategoryId;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
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
        return "SearchFacilitiesManage{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", code='" + code + '\'' +
                ", status=" + status +
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

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public SearchFacilitiesManage() {
    }

    public SearchFacilitiesManage(int pageNum, int size, String name, Integer facilitiesCategoryId, String code, Integer status, Date createStartDate, Date createEndDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.code = code;
        this.status = status;
        this.createStartDate = createStartDate;
        this.createEndDate = createEndDate;
    }
}
