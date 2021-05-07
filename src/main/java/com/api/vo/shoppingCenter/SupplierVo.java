package com.api.vo.shoppingCenter;

import java.util.Date;

/**
 * 供应商信息 Vo list 回显
 */
public class SupplierVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 供应商编号
     */
    private String code;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 负责人
     */
    private String director;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 商家地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SupplierVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SupplierVo() {
    }

    public SupplierVo(Integer id, String code, String name, String director, String tel, String address, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.director = director;
        this.tel = tel;
        this.address = address;
        this.createDate = createDate;
    }
}
