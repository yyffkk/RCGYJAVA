package com.api.vo.chargeManagement;

/**
 * 已开启的收费标准明细信息
 */
public class VoEnableTemplateDetail {
    /**
     * 收费标准明细主键id
     */
    private Integer id;
    /**
     * 收费标准明细名称
     */
    private String name;

    @Override
    public String toString() {
        return "VoEnableTemplateDetail{" +
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

    public VoEnableTemplateDetail() {
    }

    public VoEnableTemplateDetail(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
