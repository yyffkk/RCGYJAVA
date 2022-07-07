package com.api.model.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 装修押金管理信息
 */
public class UserDecorationDeposit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 押金名称
     */
    private String name;
    /**
     * 押金金额
     */
    private BigDecimal price;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "UserDecorationDeposit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public UserDecorationDeposit() {
    }

    public UserDecorationDeposit(Integer id, String name, BigDecimal price, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
