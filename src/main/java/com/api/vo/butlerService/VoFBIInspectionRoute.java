package com.api.vo.butlerService;

import java.util.List;

/**
 * 巡检路线Vo findById 回显
 */
public class VoFBIInspectionRoute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String describes;
    /**
     * 持续时间，单位为分钟
     */
    private Integer spaceTime;
    /**
     * 巡检路线-点 Vo findById 回显
     */
    private List<VoFBIInspectionRoutePoint> voRoutePointList;

    @Override
    public String toString() {
        return "VoFBIInspectionRoute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", spaceTime=" + spaceTime +
                ", voRoutePointList=" + voRoutePointList +
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
    }

    public List<VoFBIInspectionRoutePoint> getVoRoutePointList() {
        return voRoutePointList;
    }

    public void setVoRoutePointList(List<VoFBIInspectionRoutePoint> voRoutePointList) {
        this.voRoutePointList = voRoutePointList;
    }

    public VoFBIInspectionRoute() {
    }

    public VoFBIInspectionRoute(Integer id, String name, String describes, Integer spaceTime, List<VoFBIInspectionRoutePoint> voRoutePointList) {
        this.id = id;
        this.name = name;
        this.describes = describes;
        this.spaceTime = spaceTime;
        this.voRoutePointList = voRoutePointList;
    }
}
