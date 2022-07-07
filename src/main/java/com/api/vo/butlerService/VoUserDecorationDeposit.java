package com.api.vo.butlerService;

import java.math.BigDecimal;

/**
 * 装修押金Vo list 回显
 */
public class VoUserDecorationDeposit {
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

    @Override
    public String toString() {
        return "VoUserDecorationDeposit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
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

    public VoUserDecorationDeposit() {
    }

    public VoUserDecorationDeposit(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
