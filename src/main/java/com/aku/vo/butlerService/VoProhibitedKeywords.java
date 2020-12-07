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
    private String replaces;

    @Override
    public String toString() {
        return "VoProhibitedKeywords{" +
                "id=" + id +
                ", keywords='" + keywords + '\'' +
                ", replaces='" + replaces + '\'' +
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

    public String getReplaces() {
        return replaces;
    }

    public void setReplaces(String replaces) {
        this.replaces = replaces;
    }

    public VoProhibitedKeywords() {
    }

    public VoProhibitedKeywords(Integer id, String keywords, String replaces) {
        this.id = id;
        this.keywords = keywords;
        this.replaces = replaces;
    }
}
