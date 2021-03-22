package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 巡检点部分信息
 */
public class ButlerPointVo {
    /**
     * 巡检点主键Id
     */
    private Integer id;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 巡检点检查项数量
     */
    private Integer checkNum;
    /**
     * 巡检点完成时间（当时间为null时，为待巡检状态）
     */
    private Date completeDate;

    @Override
    public String toString() {
        return "ButlerPointVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkNum=" + checkNum +
                ", completeDate=" + completeDate +
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

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public ButlerPointVo() {
    }

    public ButlerPointVo(Integer id, String name, Integer checkNum, Date completeDate) {
        this.id = id;
        this.name = name;
        this.checkNum = checkNum;
        this.completeDate = completeDate;
    }
}
