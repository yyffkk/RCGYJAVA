package com.api.vo.butlerService;

/**
 * 工单类型管理Vo 回显
 */
public class VoWorkOrderType {
    /**
     * 工单类型管理主键id
     */
    private Integer id;
    /**
     * 工单大类名称
     */
    private String name;
    /**
     * 备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoWorkOrderType{" +
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

    public VoWorkOrderType() {
    }

    public VoWorkOrderType(Integer id, String name, String remake) {
        this.id = id;
        this.name = name;
        this.remake = remake;
    }
}
