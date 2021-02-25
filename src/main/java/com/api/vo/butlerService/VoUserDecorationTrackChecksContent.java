package com.api.vo.butlerService;

/**
 * 装修跟踪检查内容Vo list 回显
 */
public class VoUserDecorationTrackChecksContent {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查内容名称
     */
    private String name;
    /**
     * 备注（提示）
     */
    private String remake;

    @Override
    public String toString() {
        return "VoUserDecorationTrackChecksContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remake='" + remake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoUserDecorationTrackChecksContent() {
    }

    public VoUserDecorationTrackChecksContent(Integer id, String name, String remake) {
        this.id = id;
        this.name = name;
        this.remake = remake;
    }
}
