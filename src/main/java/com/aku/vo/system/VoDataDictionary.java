package com.aku.vo.system;

/**
 * 数据字典Vo
 */
public class VoDataDictionary {
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 值
     */
    private Integer showValue;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "VoDataDictionary{" +
                "showName='" + showName + '\'' +
                ", showValue=" + showValue +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getShowValue() {
        return showValue;
    }

    public void setShowValue(Integer showValue) {
        this.showValue = showValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public VoDataDictionary() {
    }

    public VoDataDictionary(String showName, Integer showValue, String remarks) {
        this.showName = showName;
        this.showValue = showValue;
        this.remarks = remarks;
    }
}
