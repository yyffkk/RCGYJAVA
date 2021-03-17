package com.api.model.butlerService;

/**
 * 巡检点搜索条件
 */
public class SearchInspectionPoint {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 编号
     */
    private Integer code;
    /**
     * 名称
     */
    private Integer name;

    @Override
    public String toString() {
        return "SearchInspectionPoint{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code=" + code +
                ", name=" + name +
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public SearchInspectionPoint() {
    }

    public SearchInspectionPoint(int pageNum, int size, Integer code, Integer name) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.name = name;
    }
}
