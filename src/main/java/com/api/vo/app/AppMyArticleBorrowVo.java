package com.api.vo.app;

import java.util.Date;

/**
 * app 我的借还物品信息
 */
public class AppMyArticleBorrowVo {
    /**
     * 物品借还主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品编号
     */
    private Integer code;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 归还时间
     */
    private Date endDate;
    /**
     * 借用时长
     */
    private long borrowDate;
    /**
     * 借取状态（-1.出借审核中，0.出借审核失败，1.出借中，2.已还，3.待检查,4.归还审核驳回）
     */
    private Integer borrowStatus;

    @Override
    public String toString() {
        return "AppMyArticleBorrowVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", borrowDate=" + borrowDate +
                ", borrowStatus=" + borrowStatus +
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(long borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public AppMyArticleBorrowVo() {
    }

    public AppMyArticleBorrowVo(Integer id, String name, Integer code, Date beginDate, Date endDate, long borrowDate, Integer borrowStatus) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.borrowDate = borrowDate;
        this.borrowStatus = borrowStatus;
    }
}
