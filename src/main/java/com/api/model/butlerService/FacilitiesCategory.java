package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施分类管理model
 */
public class FacilitiesCategory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施数量
     */
    private Integer num;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "FacilitiesCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", createId=" + createId +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public FacilitiesCategory() {
    }

    public FacilitiesCategory(Integer id, String code, String name, Integer num, Integer createId, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
    }
}
