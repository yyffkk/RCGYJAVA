package com.api.vo.butlerApp;

import java.util.List;

/**
 * 管家app 巡检执行点Vo 回显
 */
public class ButlerExecutePointVo {
    /**
     * 巡检执行点主键id
     */
    private Integer id;
    /**
     * 巡检点编号
     */
    private String code;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 巡检模式（1.巡检模式）【就一个模式】
     */
    private Integer type;
    /**
     * 巡检执行检查项集合
     */
    private List<ButlerExecuteCheckVo> checkVoList;

    @Override
    public String toString() {
        return "ButlerExecutePointVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", checkVoList=" + checkVoList +
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

    public List<ButlerExecuteCheckVo> getCheckVoList() {
        return checkVoList;
    }

    public void setCheckVoList(List<ButlerExecuteCheckVo> checkVoList) {
        this.checkVoList = checkVoList;
    }

    public ButlerExecutePointVo() {
    }

    public ButlerExecutePointVo(Integer id, String code, String name, Integer type, List<ButlerExecuteCheckVo> checkVoList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.checkVoList = checkVoList;
    }
}
