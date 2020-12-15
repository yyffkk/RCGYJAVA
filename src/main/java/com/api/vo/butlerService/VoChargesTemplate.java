package com.api.vo.butlerService;

/**
 * 物业收费标准模版Vo list 回显
 */
public class VoChargesTemplate {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 状态（1.启用，0.未启用）
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoChargesTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public VoChargesTemplate() {
    }

    public VoChargesTemplate(Integer id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
