package com.api.vo.butlerService;

/**
 * 巡检点检查项Vo findById 回显
 */
public class VoFBIInspectionCheckItems {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查项名称
     */
    private String name;
    /**
     * 录入项（1.抄表值，2.备注）【2选1，或者不填】
     */
    private Integer type;

    @Override
    public String toString() {
        return "VoFBIInspectionCheckItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public VoFBIInspectionCheckItems() {
    }

    public VoFBIInspectionCheckItems(Integer id, String name, Integer type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
