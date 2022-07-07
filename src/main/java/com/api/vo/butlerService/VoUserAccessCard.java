package com.api.vo.butlerService;

import java.util.Date;

/**
 * 门禁卡Vo 显示list
 */
public class VoUserAccessCard {
    /**
     * 门禁卡主键id
     */
    private Integer id;
    /**
     * 门禁卡类型（1.临时，2.永久）
     */
    private Integer type;
    /**
     * 门禁卡状态（1.正常，2.作废）
     */
    private Integer status;
    /**
     * 卡号
     */
    private String num;
    /**
     * 有效开始日期（创建时间）
     */
    private Date createDate;
    /**
     * 有效结束时间（到期时间【不填则为永久】）
     */
    private Date expireDate;

    @Override
    public String toString() {
        return "VoUserAccessCard{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", num='" + num + '\'' +
                ", createDate=" + createDate +
                ", expireDate=" + expireDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public VoUserAccessCard() {
    }

    public VoUserAccessCard(Integer id, Integer type, Integer status, String num, Date createDate, Date expireDate) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.num = num;
        this.createDate = createDate;
        this.expireDate = expireDate;
    }
}
