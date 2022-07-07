package com.api.model.butlerService;

/**
 * 巡检路线搜索条件
 */
public class SearchInspectionRoute {
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
    private String code;
    /**
     * 名称
     */
    private String name;

    @Override
    public String toString() {
        return "SearchInspectionRoute{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchInspectionRoute() {
    }

    public SearchInspectionRoute(int pageNum, int size, String code, String name) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.name = name;
    }
}
