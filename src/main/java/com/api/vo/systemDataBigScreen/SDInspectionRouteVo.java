package com.api.vo.systemDataBigScreen;

/***
 * 巡检路线Vo list 回显
 */
public class SDInspectionRouteVo {
    /**
     * 巡检路线主键id
     */
    private Integer id;
    /**
     * 巡检路线编号(系统自动)
     */
    private String code;
    /**
     * 巡检路线名称
     */
    private String name;
    /**
     * 状态（1.启用，2.停用）
     */
    private Integer status;
    /**
     * 单此路线持续时间,单位为分钟
     */
    private int spacetime;

    @Override
    public String toString() {
        return "SDInspectionRouteVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", spacetime=" + spacetime +
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

    public int getSpacetime() {
        return spacetime;
    }

    public void setSpacetime(int spacetime) {
        this.spacetime = spacetime;
    }

    public SDInspectionRouteVo() {
    }

    public SDInspectionRouteVo(Integer id, String code, String name, Integer status, int spacetime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.spacetime = spacetime;
    }
}
