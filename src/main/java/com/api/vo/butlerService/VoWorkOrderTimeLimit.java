package com.api.vo.butlerService;

/**
 * 工单时限管理Vo list 回显
 */
public class VoWorkOrderTimeLimit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 工单处理时限
     */
    private Integer timeLimit;
    /**
     * 备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoWorkOrderTimeLimit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeLimit=" + timeLimit +
                ", remake='" + remake + '\'' +
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

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoWorkOrderTimeLimit() {
    }

    public VoWorkOrderTimeLimit(Integer id, String name, Integer timeLimit, String remake) {
        this.id = id;
        this.name = name;
        this.timeLimit = timeLimit;
        this.remake = remake;
    }
}
