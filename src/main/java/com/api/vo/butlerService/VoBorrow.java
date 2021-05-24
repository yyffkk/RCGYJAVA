package com.api.vo.butlerService;

import java.util.Date;

/**
 * 借还管理Vo list 回显
 */
public class VoBorrow {
    /**
     * 借还管理主键id
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
     * 借用人
     */
    private String borrowName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 归还时间
     */
    private Date endDate;
    /**
     * 出借时长（小时）
     */
    private long borrowDate;
    /**
     * 借取状态（1.出借中，2.已还）
     */
    private Integer borrowStatus;
    /**
     * 物品状态（1.正常，2.报损）
     */
    private Integer status;
    /**
     * 备注（损坏原因）
     */
    private String remake;

    @Override
    public String toString() {
        return "VoBorrow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", borrowName='" + borrowName + '\'' +
                ", tel='" + tel + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", borrowDate=" + borrowDate +
                ", borrowStatus=" + borrowStatus +
                ", status=" + status +
                ", remake='" + remake + '\'' +
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

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoBorrow() {
    }

    public VoBorrow(Integer id, String name, Integer code, String borrowName, String tel, Date beginDate, Date endDate, long borrowDate, Integer borrowStatus, Integer status, String remake) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.borrowName = borrowName;
        this.tel = tel;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.borrowDate = borrowDate;
        this.borrowStatus = borrowStatus;
        this.status = status;
        this.remake = remake;
    }
}
