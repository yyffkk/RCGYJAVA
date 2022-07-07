package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 日活跃Vo list 回显
 */
public class SDDailyActivityVo {
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
        return "SDDailyActivityVo{" +
                "dailyActivityNum=" + dailyActivityNum +
                ", createDate=" + createDate +
                '}';
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

    public SDDailyActivityVo() {
    }

    public SDDailyActivityVo(Integer dailyActivityNum, Date createDate) {
        this.dailyActivityNum = dailyActivityNum;
        this.createDate = createDate;
    }
}
