package com.api.model.resources;

/**
 * 资源照片表
 */
public class ResourcesImg {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 数据所属ID
     */
    private Integer dateId;
    /**
     * 类型名称
     */
    private String typeName;
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
        return "ResourcesImg{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", dateId=" + dateId +
                ", typeName='" + typeName + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", longs=" + longs +
                ", paragraph=" + paragraph +
                ", sort=" + sort +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public ResourcesImg() {
    }

    public ResourcesImg(Integer id, String tableName, Integer dateId, String typeName, String url, String size, Integer longs, Integer paragraph, Integer sort) {
        this.id = id;
        this.tableName = tableName;
        this.dateId = dateId;
        this.typeName = typeName;
        this.url = url;
        this.size = size;
        this.longs = longs;
        this.paragraph = paragraph;
        this.sort = sort;
    }
}
