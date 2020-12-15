package com.api.model.butlerService;

/**
 * 物业收费标准明细 搜索条件
 */
public class SearchChargesTemplateDetail {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物业收费标准模版主键id
     */
    private Integer chargesTemplateId;
    /**
     * 费用名称
     */
    private String name;

    @Override
    public String toString() {
        return "SearchChargesTemplateDetail{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", chargesTemplateId=" + chargesTemplateId +
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

    public Integer getChargesTemplateId() {
        return chargesTemplateId;
    }

    public void setChargesTemplateId(Integer chargesTemplateId) {
        this.chargesTemplateId = chargesTemplateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchChargesTemplateDetail() {
    }

    public SearchChargesTemplateDetail(int pageNum, int size, Integer chargesTemplateId, String name) {
        this.pageNum = pageNum;
        this.size = size;
        this.chargesTemplateId = chargesTemplateId;
        this.name = name;
    }
}
