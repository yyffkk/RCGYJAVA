package com.api.model.butlerService;

/**
 * 巡检路线主键id 和 启用状态
 */
public class RouteIdAndStatus {
    /**
     * 巡检路线主键id
     */
    private Integer id;
    /**
     * 启用状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "RouteIdAndStatus{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RouteIdAndStatus() {
    }

    public RouteIdAndStatus(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }
}
