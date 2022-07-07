package com.api.model.operationManagement;

/**
 * 资讯分类搜索
 */
public class SearchNewsCategoryManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 分类编号
     */
    private String code;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 添加人姓名
     */
    private String createName;

    @Override
    public String toString() {
        return "SearchNewsCategoryManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", createName='" + createName + '\'' +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public SearchNewsCategoryManagement() {
    }

    public SearchNewsCategoryManagement(int pageNum, int size, String code, String name, String createName) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.name = name;
        this.createName = createName;
    }
}
