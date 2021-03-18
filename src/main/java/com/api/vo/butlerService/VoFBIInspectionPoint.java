package com.api.vo.butlerService;

import java.util.List;

/**
 * 巡检点Vo findById 回显
 */
public class VoFBIInspectionPoint {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 编号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 巡检模式（1.扫码）【就一个模式】
     */
    private Integer type;
    /**
     * 巡检点检查项Vo findById 回显
     */
    private List<VoFBIInspectionCheckItems> checkItemsList;

    @Override
    public String toString() {
        return "VoFBIInspectionPoint{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", checkItemsList=" + checkItemsList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<VoFBIInspectionCheckItems> getCheckItemsList() {
        return checkItemsList;
    }

    public void setCheckItemsList(List<VoFBIInspectionCheckItems> checkItemsList) {
        this.checkItemsList = checkItemsList;
    }

    public VoFBIInspectionPoint() {
    }

    public VoFBIInspectionPoint(Integer id, String code, String name, Integer type, List<VoFBIInspectionCheckItems> checkItemsList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.checkItemsList = checkItemsList;
    }
}
