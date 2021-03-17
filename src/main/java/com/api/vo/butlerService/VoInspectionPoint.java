package com.api.vo.butlerService;

import java.util.Date;

/**
 * 巡检点Vo list 回显
 */
public class VoInspectionPoint {
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
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoInspectionPoint{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoInspectionPoint() {
    }

    public VoInspectionPoint(Integer id, String code, String name, Integer type, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
    }
}
