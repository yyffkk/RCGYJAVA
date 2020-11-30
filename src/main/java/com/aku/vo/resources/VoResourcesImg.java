package com.aku.vo.resources;

/**
 * 资源照片Vo 回显
 */
public class VoResourcesImg {
    /**
     * 图片路径
     */
    private String url;
    /**
     * 图片大小
     */
    private String size;
    /**
     * 长（像素）
     */
    private Integer longs;
    /**
     * 宽（像素）
     */
    private Integer paragraph;
    /**
     * 排序
     */
    private Integer sort;

    @Override
    public String toString() {
        return "VoResourcesImg{" +
                "url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", longs=" + longs +
                ", paragraph=" + paragraph +
                ", sort=" + sort +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getLongs() {
        return longs;
    }

    public void setLongs(Integer longs) {
        this.longs = longs;
    }

    public Integer getParagraph() {
        return paragraph;
    }

    public void setParagraph(Integer paragraph) {
        this.paragraph = paragraph;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public VoResourcesImg() {
    }

    public VoResourcesImg(String url, String size, Integer longs, Integer paragraph, Integer sort) {
        this.url = url;
        this.size = size;
        this.longs = longs;
        this.paragraph = paragraph;
        this.sort = sort;
    }
}
