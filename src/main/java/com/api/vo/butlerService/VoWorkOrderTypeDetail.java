package com.api.vo.butlerService;

/**
 * 工单明细管理Vo list 回显
 */
public class VoWorkOrderTypeDetail {
    /**
     * 工单明细管理主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;

    @Override
    public String toString() {
        return "VoWorkOrderTypeDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public VoWorkOrderTypeDetail() {
    }

    public VoWorkOrderTypeDetail(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
