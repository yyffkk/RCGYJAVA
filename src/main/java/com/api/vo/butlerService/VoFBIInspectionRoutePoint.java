package com.api.vo.butlerService;

/**
 * 巡检路线-点 Vo findById 回显
 */
public class VoFBIInspectionRoutePoint {
    /**
     *  主键id
     */
    private Integer id;
    /**
     * 巡检点名称
     */
    private String name;

    @Override
    public String toString() {
        return "VoFBIInspectionRoutePoint{" +
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

    public VoFBIInspectionRoutePoint() {
    }

    public VoFBIInspectionRoutePoint(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
