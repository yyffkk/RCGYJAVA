package com.aku.vo.butlerService;

/**
 * 违禁关键字 Vo 回显 list
 */
public class VoProhibitedKeywords {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 违禁关键字
     */
    private String keywords;
    /**
     * 替换后显示的字符
     */
    private String replace;

    @Override
    public String toString() {
        return "VoProhibitedKeywords{" +
                "id=" + id +
                ", keywords='" + keywords + '\'' +
                ", replace='" + replace + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public VoProhibitedKeywords() {
    }

    public VoProhibitedKeywords(Integer id, String keywords, String replace) {
        this.id = id;
        this.keywords = keywords;
        this.replace = replace;
    }
}
