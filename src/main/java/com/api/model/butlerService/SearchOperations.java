package com.api.model.butlerService;

/**
 * 运维管理 搜索条件
 */
public class SearchOperations {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 记录编号
     */
    private String code;
    /**
     * 维修设备
     */
    private String equipment;
    /**
     * 维修类别：1.大修，2.小修，3.项修
     */
    private Integer type;
    /**
     * 维修结果：1.已修复，2.部分损坏，3.未修复
     */
    private Integer results;

    @Override
    public String toString() {
        return "SearchOperations{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", equipment='" + equipment + '\'' +
                ", type=" + type +
                ", results=" + results +
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public SearchOperations() {
    }

    public SearchOperations(int pageNum, int size, String code, String equipment, Integer type, Integer results) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.equipment = equipment;
        this.type = type;
        this.results = results;
    }
}
