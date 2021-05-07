package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 供应商信息
 */
public class Supplier {
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
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除，1.非删，0.删除
     */
    private Integer isDelete;


    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Supplier() {
    }

    public Supplier(Integer id, String code, String name, String director, String tel, String address, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.director = director;
        this.tel = tel;
        this.address = address;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
