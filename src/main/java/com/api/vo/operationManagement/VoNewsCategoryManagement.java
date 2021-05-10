package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 资讯分类管理 Vo list 回显
 */
public class VoNewsCategoryManagement {
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
     * 资讯数量
     */
    private Integer num;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoNewsCategoryManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", createName='" + createName + '\'' +
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

    public VoNewsCategoryManagement() {
    }

    public VoNewsCategoryManagement(Integer id, String code, String name, Integer num, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.num = num;
        this.createName = createName;
        this.createDate = createDate;
    }
}
