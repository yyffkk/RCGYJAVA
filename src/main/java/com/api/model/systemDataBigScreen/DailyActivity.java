package com.api.model.systemDataBigScreen;

import java.util.Date;

/**
 * 日活跃量 model 信息
 */
public class DailyActivity {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 日活跃量
     */
    private Integer dailyActivityNum;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "DailyActivity{" +
                "id=" + id +
                ", dailyActivityNum=" + dailyActivityNum +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDailyActivityNum() {
        return dailyActivityNum;
    }

    public void setDailyActivityNum(Integer dailyActivityNum) {
        this.dailyActivityNum = dailyActivityNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public DailyActivity() {
    }

    public DailyActivity(Integer id, Integer dailyActivityNum, Date createDate) {
        this.id = id;
        this.dailyActivityNum = dailyActivityNum;
        this.createDate = createDate;
    }
}
