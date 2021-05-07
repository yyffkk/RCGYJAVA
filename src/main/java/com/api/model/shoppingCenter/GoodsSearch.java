package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 商品管理 搜索条件
 */
public class GoodsSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 商品编号
     */
    private String code;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品类目
     */
    private Integer categoryId;
    /**
     * 创建开始时间
     */
    private Date createDateStart;
    /**
     * 创建结束时间
     */
    private Date createDateEnd;
    /**
     * 状态 ,1.上架，2.下架
     */
    private Integer status;

    @Override
    public String toString() {
        return "GoodsSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
                ", status=" + status +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public GoodsSearch() {
    }

    public GoodsSearch(int pageNum, int size, String code, String title, Integer categoryId, Date createDateStart, Date createDateEnd, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.title = title;
        this.categoryId = categoryId;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.status = status;
    }
}
