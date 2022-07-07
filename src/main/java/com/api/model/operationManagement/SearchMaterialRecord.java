package com.api.model.operationManagement;

/**
 * 物料出入库记录搜索条件
 */
public class SearchMaterialRecord {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 类型：1.出库，2.入库
     */
    private Integer type;

    @Override
    public String toString() {
        return "SearchMaterialRecord{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", type=" + type +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SearchMaterialRecord() {
    }

    public SearchMaterialRecord(int pageNum, int size, String name, Integer type) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.type = type;
    }
}
