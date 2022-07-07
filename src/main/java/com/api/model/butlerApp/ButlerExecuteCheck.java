package com.api.model.butlerApp;

/**
 * 管家app 巡检执行检查项
 */
public class ButlerExecuteCheck {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检执行点主键id
     */
    private Integer executePointId;
    /**
     * 检查项名称
     */
    private String name;
    /**
     * 状态：1.正常,2.异常
     */
    private Integer status;
    /**
     * 备注
     */
    private String remakes;

    @Override
    public String toString() {
        return "ButlerExecuteCheck{" +
                "id=" + id +
                ", executePointId=" + executePointId +
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

    public Integer getExecutePointId() {
        return executePointId;
    }

    public void setExecutePointId(Integer executePointId) {
        this.executePointId = executePointId;
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

    public ButlerExecuteCheck() {
    }

    public ButlerExecuteCheck(Integer id, Integer executePointId, String name, Integer status, String remakes) {
        this.id = id;
        this.executePointId = executePointId;
        this.name = name;
        this.status = status;
        this.remakes = remakes;
    }
}
