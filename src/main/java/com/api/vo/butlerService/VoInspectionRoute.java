package com.api.vo.butlerService;

import java.util.Date;

/**
 * 巡检路线Vo list 回显
 */
public class VoInspectionRoute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检路线编号
     */
    private String code;
    /**
     * 巡检路线名称
     */
    private String name;
    /**
     * 持续时间，单位为分钟
     */
    private Integer spaceTime;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 状态（1.启用，2.停用）
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoInspectionRoute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", spaceTime=" + spaceTime +
                ", createDate=" + createDate +
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

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public VoInspectionRoute() {
    }

    public VoInspectionRoute(Integer id, String code, String name, Integer spaceTime, Date createDate, Integer status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.spaceTime = spaceTime;
        this.createDate = createDate;
        this.status = status;
    }
}
