package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施分类详情 Vo findDetail 回显
 */
public class VoFacilitiesCategoryDetail {
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
     * 添加人
     */
    private String createName;
    /**
     * 添加时间
     */
    private Date createDate;
    /**
     * 联系电话
     */
    private String tel;

    @Override
    public String toString() {
        return "VoFacilitiesCategoryDetail{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", tel='" + tel + '\'' +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public VoFacilitiesCategoryDetail() {
    }

    public VoFacilitiesCategoryDetail(Integer id, String code, String name, Integer num, String createName, Date createDate, String tel) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.num = num;
        this.createName = createName;
        this.createDate = createDate;
        this.tel = tel;
    }
}
