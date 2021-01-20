package com.api.vo.app;

import java.util.Date;

/**
 * app 物品出户Vo list 回显
 */
public class AppArticleOutVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 重量(1. <50kg , 2. 50kg-100kg , 3. >100kg)
     */
    private Integer weight;
    /**
     * 预计出门时间
     */
    private Date expectedTime;
    /**
     * 搬运方式（1.自己搬运，2.搬家公司）
     */
    private Integer approach;
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;
    /**
     * 搬家公司手机号
     */
    private String movingCompanyTel;

    @Override
    public String toString() {
        return "AppArticleOutVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", expectedTime=" + expectedTime +
                ", approach=" + approach +
                ", status=" + status +
                ", movingCompanyTel='" + movingCompanyTel + '\'' +
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMovingCompanyTel() {
        return movingCompanyTel;
    }

    public void setMovingCompanyTel(String movingCompanyTel) {
        this.movingCompanyTel = movingCompanyTel;
    }

    public AppArticleOutVo() {
    }

    public AppArticleOutVo(Integer id, String name, Integer weight, Date expectedTime, Integer approach, Integer status, String movingCompanyTel) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.expectedTime = expectedTime;
        this.approach = approach;
        this.status = status;
        this.movingCompanyTel = movingCompanyTel;
    }
}
