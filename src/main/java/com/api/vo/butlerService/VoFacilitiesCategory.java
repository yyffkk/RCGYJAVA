package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施分类Vo list 回显
 */
public class VoFacilitiesCategory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分类编号
     */
    private String code;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类类型：1.设施，2.设备
     */
    private Integer type;
    /**
     * 添加人名称
     */
    private String createName;
    /**
     * 设施数量
     */
    private Integer num;
    /**
     * 添加时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createName='" + createName + '\'' +
                ", num=" + num +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFacilitiesCategory() {
    }

    public VoFacilitiesCategory(Integer id, String code, String name, Integer type, String createName, Integer num, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.createName = createName;
        this.num = num;
        this.createDate = createDate;
    }
}
