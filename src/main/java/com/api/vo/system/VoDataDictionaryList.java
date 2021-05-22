package com.api.vo.system;

/**
 * 数据字典Vo list 回显
 */
public class VoDataDictionaryList {
    /**
     * 数据字典主键id
     */
    private Integer id;
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 类型名称(英文)
     */
    private String typeName;
    /**
     * 值
     */
    private Integer showValue;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注（中文）
     */
    private String remarks;

    @Override
    public String toString() {
        return "VoDataDictionaryList{" +
                "id=" + id +
                ", showName='" + showName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", showValue=" + showValue +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getShowValue() {
        return showValue;
    }

    public void setShowValue(Integer showValue) {
        this.showValue = showValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public VoDataDictionaryList() {
    }

    public VoDataDictionaryList(Integer id, String showName, String typeName, Integer showValue, Integer sort, String remarks) {
        this.id = id;
        this.showName = showName;
        this.typeName = typeName;
        this.showValue = showValue;
        this.sort = sort;
        this.remarks = remarks;
    }
}
