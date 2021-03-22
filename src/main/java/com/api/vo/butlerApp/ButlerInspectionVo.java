package com.api.vo.butlerApp;

/**
 * 管家app 巡检管理Vo list 回显
 */
public class ButlerInspectionVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 执行巡检编号（巡检计划编号+序号）
     */
    private String code;
    /**
     * 执行巡检名称（巡检计划名称）
     */
    private String name;
    /**
     * 状态（1.待巡检（实际当次巡检结束时间为null），2.已巡检(实际当次巡检结束时间不为null)）
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerInspectionVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerInspectionVo() {
    }

    public ButlerInspectionVo(Integer id, String code, String name, Integer status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
    }
}
