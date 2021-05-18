package com.api.model.app;

/**
 * app电子商务搜索条件
 */
public class SearchAppElectronicCommerce {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 电子商务分类主键id(【全部】则传null)
     */
    private Integer electronicCommerceCategoryId;

    @Override
    public String toString() {
        return "SearchAppElectronicCommerce{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", electronicCommerceCategoryId=" + electronicCommerceCategoryId +
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

    public Integer getElectronicCommerceCategoryId() {
        return electronicCommerceCategoryId;
    }

    public void setElectronicCommerceCategoryId(Integer electronicCommerceCategoryId) {
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
    }

    public SearchAppElectronicCommerce() {
    }

    public SearchAppElectronicCommerce(int pageNum, int size, Integer electronicCommerceCategoryId) {
        this.pageNum = pageNum;
        this.size = size;
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
    }
}
