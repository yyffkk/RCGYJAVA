package com.api.vo.butlerApp;

/**
 * 管家app 巡检执行检查项
 */
public class ButlerExecuteCheckVo {
    /**
     * 巡检执行检查项
     */
    private Integer id;
    /**
     * 巡检执行检查项名称
     */
    private String name;

    @Override
    public String toString() {
        return "ButlerExecuteCheckVo{" +
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

    public ButlerExecuteCheckVo() {
    }

    public ButlerExecuteCheckVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
