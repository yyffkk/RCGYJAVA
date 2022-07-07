package com.api.model.butlerApp;

/**
 * 管家app 跟踪检查内容信息
 */
public class ButlerTrackChecksContent {
    /**
     * 跟踪检查内容主键id
     */
    private Integer id;
    /**
     * 装修主键id
     */
    private Integer decorationId;
    /**
     * 检查内容名称
     */
    private String name;

    @Override
    public String toString() {
        return "ButlerTrackChecksContent{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ButlerTrackChecksContent() {
    }

    public ButlerTrackChecksContent(Integer id, Integer decorationId, String name) {
        this.id = id;
        this.decorationId = decorationId;
        this.name = name;
    }
}
