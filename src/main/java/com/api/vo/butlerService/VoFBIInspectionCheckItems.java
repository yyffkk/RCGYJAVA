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

    @Override
    public String toString() {
        return "VoFBIInspectionCheckItems{" +
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

    public VoFBIInspectionCheckItems() {
    }

    public VoFBIInspectionCheckItems(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
