package com.api.vo.butlerApp;

/**
 * 管家app 巡检执行点检查项 Vo findById 回显
 */
public class ButlerExecuteCheckFBIVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查项名称
     */
    private String name;
    /**
     * 状态 1.正常，2.异常
     */
    private Integer status;
    /**
     * 备注
     */
    private String remakes;

    @Override
    public String toString() {
        return "ButlerExecuteCheckFBIVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", remakes='" + remakes + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public ButlerExecuteCheckFBIVo() {
    }

    public ButlerExecuteCheckFBIVo(Integer id, String name, Integer status, String remakes) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.remakes = remakes;
    }
}
