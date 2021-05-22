package com.api.model.businessManagement;

/**
 * 数据库搜索条件
 */
public class SearchDataBase {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 功能大类名称
     */
    private String functionType;
    /**
     * 功能名
     */
    private String functionName;

    @Override
    public String toString() {
        return "SearchDataBase{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", functionType='" + functionType + '\'' +
                ", functionName='" + functionName + '\'' +
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

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public SearchDataBase() {
    }

    public SearchDataBase(int pageNum, int size, String functionType, String functionName) {
        this.pageNum = pageNum;
        this.size = size;
        this.functionType = functionType;
        this.functionName = functionName;
    }
}
